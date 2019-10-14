package one.three

import org.scalatest.FunSuite

class StackTest extends FunSuite {
  test("test peek") {
    val stack = new Stack[Int]
    stack.push(1).push(2)

    assert(stack.peek() == 2)
    assert(stack.peek() == 2)
    assert(stack.pop == 2)
    assert(stack.pop == 1)
  }
}
