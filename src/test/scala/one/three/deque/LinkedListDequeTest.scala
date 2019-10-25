package one.three.deque

import org.scalatest.FunSuite

class LinkedListDequeTest extends FunSuite {
  test("test LinkedListDeque") {
    val deque = new LinkedListDeque[Int]
    deque.pushLeft(1)
    deque.pushRight(2)
    deque.pushRight(3)
    deque.pushRight(4)

    assert(deque.popRight() == 4)
    assert(deque.popLeft() == 1)
    assert(deque.popLeft() == 2)
    assert(deque.popRight() == 3)
    assert(deque.isEmpty)
  }
}
