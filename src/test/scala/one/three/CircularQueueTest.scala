package one.three

import org.scalatest.FunSuite

class CircularQueueTest extends FunSuite {
  test("Test insert in empty") {
    val queue = new CircularQueue[Int]
    queue.enqueue(1)
    assert(queue.dequeue() == 1)
    assert(queue.isEmpty())
  }

  test("Test insert 2 elements") {
    val queue = new CircularQueue[Int]
    queue.enqueue(1)
    queue.enqueue(2)

    assert(queue.dequeue() == 1)
    assert(queue.dequeue() == 2)
    assert(queue.isEmpty())
  }
}
