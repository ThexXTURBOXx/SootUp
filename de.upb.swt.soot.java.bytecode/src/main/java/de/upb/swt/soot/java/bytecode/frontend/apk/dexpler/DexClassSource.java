package de.upb.swt.soot.java.bytecode.frontend.apk.dexpler;

import com.google.common.base.Objects;
import de.upb.swt.soot.core.frontend.AbstractClassSource;
import de.upb.swt.soot.core.frontend.ResolveException;
import de.upb.swt.soot.core.inputlocation.AnalysisInputLocation;
import de.upb.swt.soot.core.model.*;
import de.upb.swt.soot.core.types.ClassType;
import de.upb.swt.soot.java.core.AnnotationUsage;
import de.upb.swt.soot.java.core.JavaSootClassSource;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class DexClassSource extends JavaSootClassSource {
    public DexClassSource(@Nonnull AnalysisInputLocation<? extends SootClass<?>> srcNamespace, @Nonnull ClassType classSignature, @Nonnull Path sourcePath) {
        super(srcNamespace, classSignature, sourcePath);
    }

    @Override
    protected Iterable<AnnotationUsage> resolveAnnotations() {
        return null;
    }

    @Nonnull
    @Override
    public Collection<? extends SootMethod> resolveMethods() throws ResolveException {
        return null;
    }

    @Nonnull
    @Override
    public Collection<? extends SootField> resolveFields() throws ResolveException {
        return null;
    }

    @Nonnull
    @Override
    public Set<Modifier> resolveModifiers() {
        return null;
    }

    @Nonnull
    @Override
    public Set<? extends ClassType> resolveInterfaces() {
        return null;
    }

    @Nonnull
    @Override
    public Optional<? extends ClassType> resolveSuperclass() {
        return Optional.empty();
    }

    @Nonnull
    @Override
    public Optional<? extends ClassType> resolveOuterClass() {
        return Optional.empty();
    }

    @Nonnull
    @Override
    public Position resolvePosition() {
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(classSource, sourcePath, classSignature);
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractClassSource<? extends SootClass<?>> that =
                (AbstractClassSource<? extends SootClass<?>>) o;
        return Objects.equal(classSource, that.getClassSource())
                && Objects.equal(sourcePath, that.getClassSource()) && Objects.equal(classSignature, that.getClassType());
    }
}
