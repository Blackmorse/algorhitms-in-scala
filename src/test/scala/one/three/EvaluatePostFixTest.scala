package one.three

import org.scalatest.FunSuite

class EvaluatePostFixTest extends FunSuite {
  test("test 1") {
    val r = EvaluatePostFix.evaluate("(1 1, 2)+")
    assert(r == 13)
  }

  test("test 2") {
    val r = EvaluatePostFix.evaluate("(100, ((1, 2)+, (3,4)-)*)/")
    assert(r == -33)
  }

  test("test from infix 1") {
    val r = EvaluatePostFix.evaluate(InfixToPostfix.evaluate("(((1 + 2) * (3 + 4))/(5 -6))"))
    assert(r == -21)
  }
}
