/* Soot - a J*va Optimization Framework
 * Copyright (C) 1997-1999 Etienne Gagnon
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the Sable Research Group and others 1997-1999.  
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */
package de.upb.soot.jimple.visitor;

import de.upb.soot.jimple.common.expr.AbstractCastExpr;
import de.upb.soot.jimple.common.expr.AbstractInstanceOfExpr;
import de.upb.soot.jimple.common.expr.AbstractInterfaceInvokeExpr;
import de.upb.soot.jimple.common.expr.AbstractLengthExpr;
import de.upb.soot.jimple.common.expr.AbstractNegExpr;
import de.upb.soot.jimple.common.expr.AbstractNewArrayExpr;
import de.upb.soot.jimple.common.expr.AbstractNewExpr;
import de.upb.soot.jimple.common.expr.AbstractNewMultiArrayExpr;
import de.upb.soot.jimple.common.expr.AbstractSpecialInvokeExpr;
import de.upb.soot.jimple.common.expr.AbstractStaticInvokeExpr;
import de.upb.soot.jimple.common.expr.AbstractVirtualInvokeExpr;
import de.upb.soot.jimple.common.expr.JAddExpr;
import de.upb.soot.jimple.common.expr.JAndExpr;
import de.upb.soot.jimple.common.expr.JCmpExpr;
import de.upb.soot.jimple.common.expr.JCmpgExpr;
import de.upb.soot.jimple.common.expr.JCmplExpr;
import de.upb.soot.jimple.common.expr.JDivExpr;
import de.upb.soot.jimple.common.expr.JDynamicInvokeExpr;
import de.upb.soot.jimple.common.expr.JEqExpr;
import de.upb.soot.jimple.common.expr.JGeExpr;
import de.upb.soot.jimple.common.expr.JGtExpr;
import de.upb.soot.jimple.common.expr.JLeExpr;
import de.upb.soot.jimple.common.expr.JLtExpr;
import de.upb.soot.jimple.common.expr.JMulExpr;
import de.upb.soot.jimple.common.expr.JNeExpr;
import de.upb.soot.jimple.common.expr.JOrExpr;
import de.upb.soot.jimple.common.expr.JRemExpr;
import de.upb.soot.jimple.common.expr.JShlExpr;
import de.upb.soot.jimple.common.expr.JShrExpr;
import de.upb.soot.jimple.common.expr.JSubExpr;
import de.upb.soot.jimple.common.expr.JUshrExpr;
import de.upb.soot.jimple.common.expr.JXorExpr;

public interface IExprVisitor extends IVisitor {
  public abstract void caseAddExpr(JAddExpr v);

  public abstract void caseAndExpr(JAndExpr v);

  public abstract void caseCmpExpr(JCmpExpr v);

  public abstract void caseCmpgExpr(JCmpgExpr v);

  public abstract void caseCmplExpr(JCmplExpr v);

  public abstract void caseDivExpr(JDivExpr v);

  public abstract void caseEqExpr(JEqExpr v);

  public abstract void caseNeExpr(JNeExpr v);

  public abstract void caseGeExpr(JGeExpr v);

  public abstract void caseGtExpr(JGtExpr v);

  public abstract void caseLeExpr(JLeExpr v);

  public abstract void caseLtExpr(JLtExpr v);

  public abstract void caseMulExpr(JMulExpr v);

  public abstract void caseOrExpr(JOrExpr v);

  public abstract void caseRemExpr(JRemExpr v);

  public abstract void caseShlExpr(JShlExpr v);

  public abstract void caseShrExpr(JShrExpr v);

  public abstract void caseUshrExpr(JUshrExpr v);

  public abstract void caseSubExpr(JSubExpr v);

  public abstract void caseXorExpr(JXorExpr v);

  public abstract void caseInterfaceInvokeExpr(AbstractInterfaceInvokeExpr v);

  public abstract void caseSpecialInvokeExpr(AbstractSpecialInvokeExpr v);

  public abstract void caseStaticInvokeExpr(AbstractStaticInvokeExpr v);

  public abstract void caseVirtualInvokeExpr(AbstractVirtualInvokeExpr v);

  public abstract void caseDynamicInvokeExpr(JDynamicInvokeExpr v);

  public abstract void caseCastExpr(AbstractCastExpr v);

  public abstract void caseInstanceOfExpr(AbstractInstanceOfExpr v);

  public abstract void caseNewArrayExpr(AbstractNewArrayExpr v);

  public abstract void caseNewMultiArrayExpr(AbstractNewMultiArrayExpr v);

  public abstract void caseNewExpr(AbstractNewExpr v);

  public abstract void caseLengthExpr(AbstractLengthExpr v);

  public abstract void caseNegExpr(AbstractNegExpr v);

  public abstract void defaultCase(Object obj);
}