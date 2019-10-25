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

  test("test circular iterator with one element") {
    val queue = new CircularQueue[Int]
    queue.enqueue(1)

    val iterator = queue.circularIterator()

    1 to 10 foreach (_ => assert(iterator.next() == 1))
  }

  test("test circular iterator") {
    val queue = new CircularQueue[Int]
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    val iterator = queue.circularIterator()

    val array = LazyList.continually(iterator.next()).take(10).toArray
    assert(array sameElements Array(1, 2, 3, 1, 2, 3, 1, 2, 3, 1))
  }

  test("test remove one element") {
    val queue = new CircularQueue[Int]
    queue.enqueue(1)

    val iterator = queue.circularIterator()

    iterator.remove()
    assert(iterator.isEmpty)
    assert(queue.isEmpty())
  }

  test("test remove elements") {
    val queue = new CircularQueue[Int]
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    val iterator = queue.circularIterator()
    iterator.remove()
    assert(iterator.next() == 2)
    iterator.remove()
    assert(iterator.next() == 2)

    assert(queue.dequeue() == 2)
    assert(queue.isEmpty())
  }
}
