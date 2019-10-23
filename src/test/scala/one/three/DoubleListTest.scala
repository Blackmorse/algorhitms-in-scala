package one.three

import org.scalatest.FunSuite

class DoubleListTest extends FunSuite {
  test("test insert beginning") {
    val list = new DoubleList[Int]
    list.insertBeginning(1)
    list.insertBeginning(2)

    val iterator = list.iterator
    assert(iterator.next() == 2)
    assert(iterator.next() == 1)
    assert(!iterator.hasNext)

    val rIterator = list.reverseIterator
    assert(rIterator.next() == 1)
    assert(rIterator.next() == 2)
    assert(!rIterator.hasNext)
  }

  test("test insert end") {
    val list = new DoubleList[Int]
    list.insertEnd(1)
    list.insertEnd(2)

    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)

    val rIterator = list.reverseIterator
    assert(rIterator.next() == 2)
    assert(rIterator.next() == 1)
    assert(!rIterator.hasNext)
  }

  test("test remove from beginning") {
    val list = new DoubleList[Int]
    list.insertEnd(1)
    list.insertEnd(2)
    val r = list.removeFromBeginning()
    assert(r == 1)
    val iterator = list.iterator
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)

    val rIterator = list.reverseIterator
    assert(rIterator.next() == 2)
    assert(!rIterator.hasNext)
  }

  test("test remove from beginning with one element") {
    val list = new DoubleList[Int]
    list.insertEnd(1)
    val r = list.removeFromBeginning()
    assert(r == 1)
    assert(!list.iterator.hasNext)
    assert(!list.reverseIterator.hasNext)
  }

  test("remove from end") {
    val list = new DoubleList[Int]
    list.insertEnd(1)
    list.insertEnd(2)
    val r = list.removeFromEnd()
    assert(r == 2)
    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(!iterator.hasNext)

    val rIterator = list.reverseIterator
    assert(rIterator.next() == 1)
    assert(!rIterator.hasNext)
  }


  test("test remove from end with one element") {
    val list = new DoubleList[Int]
    list.insertEnd(1)
    val r = list.removeFromEnd()
    assert(r == 1)
    assert(!list.iterator.hasNext)
    assert(!list.reverseIterator.hasNext)
  }

  test("test insertBefore") {
    val list = new DoubleList[Int]
    list.insertEnd(1)
    list.insertEnd(2)

    val node = list.first.next

    DoubleList.insertBefore(node, 3)

    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 3)
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)

    val rIterator = list.reverseIterator
    assert(rIterator.next() == 2)
    assert(rIterator.next() == 3)
    assert(rIterator.next() == 1)
    assert(!rIterator.hasNext)
  }

  test("test insert after last element") {
    val list = new DoubleList[Int]
    list.insertEnd(1)

    val node = list.first

    DoubleList.insertAfter(node, 2)

    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)

    val rIterator = list.reverseIterator
    assert(rIterator.next() == 2)
    assert(rIterator.next() == 1)
    assert(!rIterator.hasNext)
  }

  test("test insert after in the middle") {
    val list = new DoubleList[Int]
    list.insertEnd(1)
    list.insertEnd(2)

    val node = list.first
    DoubleList.insertAfter(node, 3)

    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 3)
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)

    val rIterator = list.reverseIterator
    assert(rIterator.next() == 2)
    assert(rIterator.next() == 3)
    assert(rIterator.next() == 1)
    assert(!rIterator.hasNext)
  }

  test("test remove node from end") {
    val list = new DoubleList[Int]
    list.insertEnd(1)
    list.insertEnd(2)

    val node = list.first.next

    DoubleList.remove(node)

    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(!iterator.hasNext)

    val rIterator = list.reverseIterator
    assert(rIterator.next() == 1)
    assert(!rIterator.hasNext)
  }

  test("test remove node from the middle") {
    val list = new DoubleList[Int]
    list.insertEnd(1)
    list.insertEnd(2)
    list.insertEnd(3)

    val node = list.first.next

    DoubleList.remove(node)

    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 3)
    assert(!iterator.hasNext)

    val rIterator = list.reverseIterator
    assert(rIterator.next() == 3)
    assert(rIterator.next() == 1)
    assert(!rIterator.hasNext)
  }
}
