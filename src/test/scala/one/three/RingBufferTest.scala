package one.three

import org.scalatest.FunSuite

class RingBufferTest extends FunSuite {
  test("enqueue and dequeue") {
    val ring = new RingBuffer[Int](3)
    ring.enqueue(1)
    ring.enqueue(2)

    assert(ring.dequeue() == 1)
    assert(ring.dequeue() == 2)
    assert(ring.size == 0)
  }

  test("enqueue and dequeue more than capacity") {
    val ring = new RingBuffer[Int](3)
    ring.enqueue(1)
    ring.enqueue(2)
    ring.enqueue(3)

    assert(ring.dequeue() == 1)
    assert(ring.dequeue() == 2)

    ring.enqueue(4)
    ring.enqueue(5)

    assert(ring.dequeue() == 3)
    assert(ring.dequeue() == 4)
    assert(ring.dequeue() == 5)

    ring.enqueue(6)
    ring.enqueue(7)
    ring.enqueue(8)

    assert(ring.dequeue() == 6)
    assert(ring.dequeue() == 7)
    assert(ring.dequeue() == 8)
  }

  test("test waiting for enqueue") {
    val queue = new RingBuffer[Int](3)

    new Thread(() => {Thread.sleep(300); queue.enqueue(10)}).start()

    assert(queue.dequeue() == 10)
  }

  test("test waiting to dequeue") {
    val queue = new RingBuffer[Int](2)
    queue.enqueue(1)
    queue.enqueue(2)

    new Thread(() => {Thread.sleep(300); queue.dequeue()}).start()

    queue.enqueue(3)

    assert(queue.dequeue() == 2)
    assert(queue.dequeue() == 3)
  }
}
