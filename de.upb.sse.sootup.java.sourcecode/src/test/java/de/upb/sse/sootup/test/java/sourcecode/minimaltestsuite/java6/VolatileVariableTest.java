package de.upb.sse.sootup.test.java.sourcecode.minimaltestsuite.java6;

import static org.junit.Assert.assertTrue;

import de.upb.sse.sootup.core.model.Modifier;
import de.upb.sse.sootup.core.model.SootClass;
import de.upb.sse.sootup.core.model.SootMethod;
import de.upb.sse.sootup.core.signatures.MethodSignature;
import de.upb.sse.sootup.test.java.sourcecode.minimaltestsuite.MinimalSourceTestSuiteBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/** @author Kaustubh Kelkar */
public class VolatileVariableTest extends MinimalSourceTestSuiteBase {
  public MethodSignature getMethodSignature() {
    return identifierFactory.getMethodSignature(
        getDeclaredClassSignature(), "increaseCounter", "int", Collections.emptyList());
  }

  @Test
  public void test() {
    SootMethod method = loadMethod(getMethodSignature());
    assertJimpleStmts(method, expectedBodyStmts());
    SootClass<?> clazz = loadClass(getDeclaredClassSignature());
    assertTrue(
        clazz.getFields().stream()
            .anyMatch(
                sootField -> {
                  return sootField.getName().equals("counter")
                      && sootField.getModifiers().contains(Modifier.VOLATILE);
                }));
  }

  /**
   *
   *
   * <pre>
   *     public int increaseCounter(){
   * return counter++;
   * }
   * </pre>
   */
  @Override
  public List<String> expectedBodyStmts() {
    return Stream.of(
            "r0 := @this: VolatileVariable",
            "$i0 = r0.<VolatileVariable: int counter>",
            "$i1 = $i0 + 1",
            "r0.<VolatileVariable: int counter> = $i1",
            "return $i0")
        .collect(Collectors.toCollection(ArrayList::new));
  }
}