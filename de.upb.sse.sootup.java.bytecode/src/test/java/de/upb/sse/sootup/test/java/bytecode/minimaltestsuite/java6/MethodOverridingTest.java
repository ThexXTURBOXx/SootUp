package de.upb.sse.sootup.test.java.bytecode.minimaltestsuite.java6;

import categories.Java8Test;
import de.upb.sse.sootup.core.model.SootMethod;
import de.upb.sse.sootup.core.signatures.MethodSignature;
import de.upb.sse.sootup.test.java.bytecode.minimaltestsuite.MinimalBytecodeTestSuiteBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/** @author Kaustubh Kelkar */
@Category(Java8Test.class)
public class MethodOverridingTest extends MinimalBytecodeTestSuiteBase {

  public MethodSignature getMethodSignature() {

    return identifierFactory.getMethodSignature(
        identifierFactory.getClassType("MethodOverridingSubclass"),
        "calculateArea",
        "void",
        Collections.emptyList());
  }

  /**
   *
   *
   * <pre>
   * public void calculateArea(){
   * System.out.println("Inside MethodOverriding-calculateArea()");
   * }
   *
   * </pre>
   */
  @Override
  public List<String> expectedBodyStmts() {
    return Stream.of(
            "l0 := @this: MethodOverridingSubclass",
            "$stack1 = <java.lang.System: java.io.PrintStream out>",
            "virtualinvoke $stack1.<java.io.PrintStream: void println(java.lang.String)>(\"Inside MethodOverridingSubclass-calculateArea()\")",
            "return")
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Test
  public void test() {
    SootMethod method = loadMethod(getMethodSignature());
    assertJimpleStmts(method, expectedBodyStmts());
  }
}