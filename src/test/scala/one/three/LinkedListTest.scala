package one.three

import org.scalatest.FunSuite

class LinkedListTest extends FunSuite {
  test("test add") {
    val list = new LinkedList[Int]
    list.add(1)
    list.add(2)
    list.add(3)

    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(iterator.next() == 3)
    assert(!iterator.hasNext)
  }

  test("test remove last") {
    val list = new LinkedList[Int]
    list.add(1)
    list.add(2)
    list.add(3)

    list.removeLast()
    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)
  }

  test("Remove from empty list") {
    val list = new LinkedList[Int]
    list.removeLast()
    assert(list.isEmpty)
  }
}
