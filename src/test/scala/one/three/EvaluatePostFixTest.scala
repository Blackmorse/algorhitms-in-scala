package one.three

import org.scalatest.FunSuite

class PostFixEvaluatorTest extends FunSuite {
  test("test 1") {
    val r = PostFixEvaluator.evaluate("(1 1, 2)+")
    assert(r == 13)
  }

  test("test 2") {
    val r = PostFixEvaluator.evaluate("(100, ((1, 2)+, (3,4)-)*)/")
    assert(r == -33)
  }

  test("test from infix 1") {
    val r = PostFixEvaluator.evaluate(InfixToPostfix.evaluate("(((1 + 2) * (3 + 4))/(5 -6))"))
    assert(r == -21)
  }
}
