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

  test("test copy constructor") {
    val stack = new Stack[Int]()

    stack.push(1).push(2).push(3)

    val newStack = new Stack[Int](stack)

    assert(newStack.pop == 3)
    assert(newStack.pop == 2)
    assert(newStack.pop == 1)
    assert(newStack.isEmpty)

    assert(stack.pop == 3)
    assert(stack.pop == 2)
    assert(stack.pop == 1)
    assert(stack.isEmpty)
  }
}
