package one.three

import org.scalatest.FunSuite

class InfixToPostfixTest extends FunSuite {
  test("test1") {
    val r = InfixToPostfix.evaluate("(1 + 2 2)")
    assert(r == "(1, 22)+")
  }

  test("test2") {
    val r = InfixToPostfix.evaluate("((1 + 2) * 3)")
    assert(r == "((1, 2)+, 3)*")
  }

  test("test3") {
    val r = InfixToPostfix.evaluate("(((1 + 2) / (3 *   4)) - 5)")
    assert(r == "(((1, 2)+, (3, 4)*)/, 5)-")
  }
}
