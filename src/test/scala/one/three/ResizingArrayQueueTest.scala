package one.three

import org.scalatest.FunSuite

class ResizingArrayQueueTest extends FunSuite {
  test("test fixed size") {
    val queue = new ResizingArrayQueue[Int](3)
    queue.enqueue(1).enqueue(2).enqueue(3)

    assert(queue.size == 3)
    assert(queue.dequeue() == 1)
    assert(queue.size == 2)
    assert(queue.dequeue() == 2)
    assert(queue.size == 1)
    assert(queue.dequeue() == 3)

    assert(queue.size == 0)
  }

  test("test dequeue all and the enqueue") {
    val queue = new ResizingArrayQueue[Int](2)

    queue.enqueue(1).enqueue(2)
    queue.dequeue()
    queue.dequeue()

    queue.enqueue(3)
    assert(queue.size == 1)
    assert(queue.dequeue() == 3)
  }

  test("test too much dequeue") {
    val queue = new ResizingArrayQueue[Int](2)
    queue.enqueue(1)
    queue.dequeue()

    assertThrows[IllegalArgumentException] {
      queue.dequeue()
    }
  }

  test("test extend array") {
    val queue = new ResizingArrayQueue[Int](2)
    queue.enqueue(1).enqueue(2).enqueue(3)
    queue.dequeue()
    queue.dequeue()
    assert(queue.dequeue() == 3)
  }

  test("test shrink") {
    val queue = new ResizingArrayQueue[Int](20)
    queue.enqueue(1).enqueue(2).enqueue(3)
    assert(queue.dequeue() == 1)
    assert(queue.arr.length == 5)
    assert(queue.dequeue() == 2)
    assert(queue.dequeue() == 3)
  }

  test("test iterator") {
    val queue = new ResizingArrayQueue[Int](1)
    queue.enqueue(1).enqueue(2).enqueue(3)
    val iterator = queue.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(iterator.next() == 3)
    assert(!iterator.hasNext)
  }

  test("test isEmpty") {
    val queue = new ResizingArrayQueue[Int](1)
    assert(queue.isEmpty)
    queue.enqueue(1)
    assert(!queue.isEmpty)
    queue.dequeue()
    assert(queue.isEmpty)
  }
}
