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

import de.upb.soot.jimple.MethodHandle;
import de.upb.soot.jimple.common.constant.ClassConstant;
import de.upb.soot.jimple.common.constant.DoubleConstant;
import de.upb.soot.jimple.common.constant.FloatConstant;
import de.upb.soot.jimple.common.constant.IntConstant;
import de.upb.soot.jimple.common.constant.LongConstant;
import de.upb.soot.jimple.common.constant.NullConstant;
import de.upb.soot.jimple.common.constant.StringConstant;

public interface IConstantVisitor extends IVisitor {
  public abstract void caseDoubleConstant(DoubleConstant v);

  public abstract void caseFloatConstant(FloatConstant v);

  public abstract void caseIntConstant(IntConstant v);

  public abstract void caseLongConstant(LongConstant v);

  public abstract void caseNullConstant(NullConstant v);

  public abstract void caseStringConstant(StringConstant v);

  public abstract void caseClassConstant(ClassConstant v);

  public abstract void caseMethodHandle(MethodHandle handle);

  public abstract void defaultCase(Object object);
}