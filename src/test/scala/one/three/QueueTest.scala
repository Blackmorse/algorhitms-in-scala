package one.three

import org.scalatest.FunSuite

class QueueTest extends FunSuite {
  test("test from queue to stack and back") {
    val q = new Queue[String]
    q.enqueue("1").enqueue("2").enqueue("3")

    val stack = new Stack[String]
    while (!q.isEmpty) stack.push(q.dequeue)
    while (!stack.isEmpty) q.enqueue(stack.pop)

    assert("3" == q.dequeue())
    assert("2" == q.dequeue())
    assert("1" == q.dequeue())
  }

  test("test copy constructor") {
    val queue = new Queue[Int]()
    queue.enqueue(1).enqueue(2).enqueue(3)

    val queue2 = new Queue[Int](queue)

    val iterator = queue.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(iterator.next() == 3)
    assert(!iterator.hasNext)

    val iterator2 = queue2.iterator

    assert(iterator2.next() == 1)
    assert(iterator2.next() == 2)
    assert(iterator2.next() == 3)
    assert(!iterator2.hasNext)
  }
}
