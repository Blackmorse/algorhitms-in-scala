package one.three.generalizedqueue

import org.scalatest.{BeforeAndAfter, FunSuite}

abstract class GeneralizedQueueTest extends FunSuite with BeforeAndAfter {
  var queue: GeneralizedQueue[Int] = null

//  before {
//    queue = new ArrayGeneralizedQueue[Int](5)
//  }

  test("test insert") {
    queue.insert(1)
    queue.insert(2)
    queue.insert(3)

    assert(queue.size == 3)

    val iterator = queue.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(iterator.next() == 3)
    assert(!iterator.hasNext)
  }

  test("test insert with increasing array size") {
    1 to 10 foreach (queue.insert(_))

    assert(queue.size == 10)

    val iterator = queue.iterator
    1 to 10 foreach(i => assert(iterator.next() == i))
    assert(!iterator.hasNext)
  }

  test("test remove first") {
    queue.insert(1)
    queue.insert(2)

    assert(queue.delete(0) == 1)

    val iterator = queue.iterator
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)
  }

  test("test remove last") {
    queue.insert(1)
    queue.insert(2)
    queue.insert(3)

    assert(queue.delete(2) == 3)

    val iterator = queue.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)
  }

  test("test remove middle") {
    queue.insert(1)
    queue.insert(2)
    queue.insert(3)

    assert(queue.delete(1) == 2)

    val iterator = queue.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 3)
    assert(!iterator.hasNext)
  }

  test("test remove and add") {
    1 to 10 foreach (queue.insert(_))
    1 to 10 foreach (i => assert(queue.delete(0) == i))

    11 to 20 foreach (queue.insert(_))
    val iterator = queue.iterator
    11 to 20 foreach (i => iterator.next() == i)
    assert(!iterator.hasNext)
  }
}
