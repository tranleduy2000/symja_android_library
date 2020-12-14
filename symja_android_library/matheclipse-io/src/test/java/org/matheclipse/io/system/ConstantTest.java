package org.matheclipse.io.system;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.basic.ToggleFeature;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.script.engine.MathScriptEngine;

/** Tests for SparseArray functions */
public class ConstantTest extends AbstractTestCase {

  public ConstantTest(String name) {
    super(name);
  }

  public void _testIn() {
    check(
        "x=1", //
        "1");
    check(
        "x = x + 1", //
        "2");
    check(
        "Do(In(2), {3})", //
        "");
    check(
        "x", //
        "5");
    check(
        "In(-1)", //
        "5");
    check(
        "Definition(In)",
        "Attributes(In)={Listable,NHoldFirst,Protected}\n"
            + "In(1):=x=1\n"
            + "In(2):=x=x+1\n"
            + "In(3):=Do(In(2),{3})\n"
            + "In(4):=x\n"
            + "In(5):=In(-1)");
  }

  public void _testLine() {
    check(
        "$Line", //
        "1");
    check(
        "$Line", //
        "2");
  }

  public void testIterationLimit() {
    check(
        "f(x_) := f(x + 1)", //
        "");
    check(
        "f(x)", //
        "Hold(f(x))");
  }

  public void _testOut() {
    check(
        "42", //
        "42");
    check(
        "%", //
        "42");
    check(
        "43", //
        "43");
    check(
        "%", //
        "43");
    check(
        "44", //
        "44");
    check(
        "%1", //
        "42");
    check(
        "%%", //
        "44");
    check(
        "Hold(Out(-1))", //
        "Hold(%)");
    check(
        "Hold(%4)", //
        "Hold(Out(4))");
    check(
        "Out(0)", //
        "Out(0)");
    check(
        "Sin(Pi);", //
        "");
    check(
        "%", //
        "");
    check(
        "Definition(Out)",
        "Attributes(Out)={Listable,NHoldFirst,Protected}\n"
            + "Out(2)=42\n"
            + "Out(4)=43\n"
            + "Out(5)=44\n"
            + "Out(6)=42\n"
            + "Out(7)=44\n"
            + "Out(8)=Hold(%)\n"
            + "Out(9)=Hold(Out(4))\n"
            + "Out(10)=Out(0)\n"
            + "Out(11)=Null\n"
            + "Out(12)=Null");
  }

  public void testRecursionLimit() {
    // messges $RecursionLimit: Recursion depth of ... exceeded during evaluation of ...
    check(
        "a = a + a", //
        "Hold(a=a+a)");
    check(
        "a", //
        "Hold(a)");

    check(
        "a := a + a", //
        "");
    check(
        "a", //
        "Hold(a)");
  }

  /** The JUnit setup method */
  @Override
  protected void setUp() {
    super.setUp();
    Config.SHORTEN_STRING_LENGTH = 1024;
    Config.MAX_AST_SIZE = 1000000;
    EvalEngine.get().setIterationLimit(50000);
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    Config.SHORTEN_STRING_LENGTH = 80;
  }
}
