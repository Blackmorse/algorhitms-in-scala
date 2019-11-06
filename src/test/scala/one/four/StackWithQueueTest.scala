package one.four

import org.scalatest.FunSuite

class StackWithQueueTest extends FunSuite {
  test("test stack") {
    val stack = new StackWithQueue[Int]
    stack.push(1)
    stack.push(2)
    stack.push(3)

    assert(stack.pop() == 3)
    assert(stack.pop() == 2)
    assert(!stack.isEmpty)

    stack.push(4)
    assert(stack.pop() == 4)
    assert(stack.pop() == 1)
    assert(stack.isEmpty)
  }
}
