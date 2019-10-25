package one.three

import edu.princeton.cs.algs4.StdRandom
import org.scalatest.FunSuite

class RandomQueueTest extends FunSuite {
  test("test random queue") {
    StdRandom.setSeed(1L)

    val queue = new RandomQueue[Int]
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)
    queue.enqueue(5)

    val samples = LazyList.continually(queue.sample()).take(5).toArray
    assert(samples sameElements Array(1, 4, 3, 4, 5))
    val dequeues = LazyList.continually(queue.dequeue()).take(5).toArray
    assert(dequeues sameElements  Array(5, 3, 4, 1, 2))
    assert(queue.isEmpty)
  }
}
