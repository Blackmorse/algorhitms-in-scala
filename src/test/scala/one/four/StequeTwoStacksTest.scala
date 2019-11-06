package one.four

import org.scalatest.FunSuite

class StequeTwoStacksTest extends FunSuite {
  test("Test steque") {
    val steque = new StequeTwoStacks[Int]

    steque.push(1)
    steque.push(2)
    steque.enqueue(3)
    steque.enqueue(4)
    steque.push(5)

    assert(steque.pop() == 5)
    assert(steque.pop() == 2)
    assert(steque.pop() == 1)
    assert(!steque.isEmpty)

    steque.enqueue(6)
    steque.enqueue(7)

    assert(steque.pop() == 3)
    assert(steque.pop() == 4)
    assert(steque.pop() == 6)
    assert(steque.pop() == 7)
    assert(steque.isEmpty)
  }
}
