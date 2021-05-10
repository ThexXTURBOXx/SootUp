package de.upb.swt.soot.core.jimple.common.ref;

/*-
 * #%L
 * Soot - a J*va Optimization Framework
 * %%
 * Copyright (C) 1997-2020 Raja Vallee-Rai, Linghui Luo, Christian Brüggemann
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

import de.upb.swt.soot.core.model.SootClass;
import de.upb.swt.soot.core.model.SootField;
import de.upb.swt.soot.core.signatures.FieldSignature;
import de.upb.swt.soot.core.types.Type;
import de.upb.swt.soot.core.views.View;
import java.util.Optional;
import javax.annotation.Nonnull;

public abstract class JFieldRef implements ConcreteRef {

  @Nonnull private final FieldSignature fieldSignature;

  JFieldRef(@Nonnull FieldSignature fieldSignature) {
    this.fieldSignature = fieldSignature;
  }

  @Nonnull
  public Optional<SootField> getField(@Nonnull View<? extends SootClass> view) {
    return view.getClass(fieldSignature.getDeclClassType())
        .flatMap(it -> it.getField(fieldSignature).map(field -> (SootField) field));
  }

  @Nonnull
  public FieldSignature getFieldSignature() {
    return fieldSignature;
  }

  @Override
  public Type getType() {
    return fieldSignature.getType();
  }

  public boolean equals(JFieldRef ref) {
    if (this == ref) {
      return true;
    }
    return this.getFieldSignature().equals(ref.getFieldSignature());
  }
}
