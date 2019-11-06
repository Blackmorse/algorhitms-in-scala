package one.four

import org.scalatest.FunSuite

class QueueTwoStacksTest extends FunSuite {
  test("test push and pop") {
    val queue = new QueueTwoStacks[Int]
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    assert(queue.dequeue() == 1)
    assert(queue.dequeue() == 2)
    assert(queue.dequeue() == 3)
    assert(queue.isEmpty)

    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    assert(queue.dequeue() == 1)
    assert(queue.dequeue() == 2)
    assert(queue.dequeue() == 3)
    assert(queue.isEmpty)
  }

}
