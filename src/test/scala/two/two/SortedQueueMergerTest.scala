package two.two

import one.three.Queue
import org.scalatest.FunSuite

class SortedQueueMergerTest extends FunSuite {
  test("test") {
    val q1 = new Queue[Int].enqueue(1).enqueue(5).enqueue(7)
    val q2 = new Queue[Int].enqueue(2).enqueue(3).enqueue(6)

    val res = SortedQueueMerger.merge(q1, q2)

    assert(res.toArray sameElements Array(1,2,3,5,6,7))
  }

  test("test 3") {
    val q1 = new Queue[Int].enqueue(1).enqueue(9).enqueue(11)
    val q2 = new Queue[Int].enqueue(4)

    val res = SortedQueueMerger.merge(q1, q2)

    assert(res.toArray sameElements Array(1,4,9,11))
  }
}
