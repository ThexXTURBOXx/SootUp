package sootup.java.bytecode.interceptors.typeresolving;

/*-
 * #%L
 * SootUp
 * %%
 * Copyright (C) 1997 - 2023 Raja Vallée-Rai and others
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */

import javax.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sootup.core.jimple.basic.Local;
import sootup.core.jimple.basic.Value;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.Body;
import sootup.core.types.PrimitiveType;
import sootup.core.types.Type;

public class TypePromotionVisitor extends TypeChecker {

  private boolean failed = false;
  private boolean typingChanged = true;

  private static final Logger logger = LoggerFactory.getLogger(TypePromotionVisitor.class);

  public TypePromotionVisitor(
      @Nonnull Body.BodyBuilder builder,
      @Nonnull AugEvalFunction evalFunction,
      @Nonnull BytecodeHierarchy hierarchy) {
    super(builder, evalFunction, hierarchy);
  }

  public Typing getPromotedTyping(Typing typing) {
    setTyping(typing);
    this.failed = false;
    while (typingChanged && !failed) {
      this.typingChanged = false;
      // TODO:  [ms] check if we need the copy of getStmts()
      for (Stmt stmt : builder.getStmts()) {
        stmt.accept(this);
      }
    }
    if (failed) {
      return null;
    }
    return getTyping();
  }

  public void visit(@Nonnull Value value, @Nonnull Type stdType, @Nonnull Stmt stmt) {
    AugEvalFunction evalFunction = getFuntion();
    BytecodeHierarchy hierarchy = getHierarchy();
    Typing typing = getTyping();
    Type evaType = evalFunction.evaluate(typing, value, stmt, graph);
    if (evaType.equals(stdType)) {
      return;
    }
    if (!hierarchy.isAncestor(stdType, evaType)) {
      logger.error(
          stdType
              + " is not compatible with the value '"
              + value
              + "' in the statement: '"
              + stmt
              + "' !");
      this.failed = true;
    } else if (value instanceof Local && Type.isIntermediateType(evaType)) {
      Local local = (Local) value;
      Type promotedType = promote(evaType, stdType);
      if (promotedType != null && !promotedType.equals(evaType)) {
        typing.set(local, promotedType);
        this.typingChanged = true;
      }
    }
  }

  private Type promote(Type low, Type high) {
    if (low instanceof PrimitiveType.Integer1Type) {
      if (high instanceof PrimitiveType.IntType) {
        return PrimitiveType.getInteger127();
      } else if (high instanceof PrimitiveType.ShortType) {
        return PrimitiveType.getByte();
      } else if (high instanceof PrimitiveType.IntType) {
        return high;
      } else {
        logger.error(low + " cannot be promoted with the supertype " + high.toString() + "!");
        return null;
      }
    } else if (low instanceof PrimitiveType.Integer127Type) {
      if (high instanceof PrimitiveType.ShortType) {
        return PrimitiveType.getByte();
      } else if (high instanceof PrimitiveType.IntType) {
        return PrimitiveType.getInteger127();
      } else if (high instanceof PrimitiveType.ByteType
          || high instanceof PrimitiveType.CharType
          || high instanceof PrimitiveType.Integer32767Type) {
        return high;
      } else {
        logger.error(low + " cannot be promoted with the supertype " + high.toString() + "!");
        return null;
      }
    } else if (low instanceof PrimitiveType.Integer32767Type) {
      if (high instanceof PrimitiveType.IntType) {
        return PrimitiveType.getInteger32767();
      } else if (high instanceof PrimitiveType.ShortType
          || high instanceof PrimitiveType.CharType) {
        return high;
      } else {
        logger.error(low + " cannot be promoted with the supertype " + high.toString() + "!");
        return null;
      }
    } else {
      logger.error(low + " cannot be promoted with the supertype " + high.toString() + "!");
      return null;
    }
  }
}
