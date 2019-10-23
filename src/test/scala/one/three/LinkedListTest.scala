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

    val v = list.removeLast()
    assert(v == 3)
    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)
  }

  test("test remove only one") {
    val list = new LinkedList[Int]
    list.add(1)
    val v = list.removeLast()
    assert(v == 1)
    list.add(2)

    val iterator = list.iterator
    assert(iterator.next() == 2)
  }

  test("Remove from empty list") {
    val list = new LinkedList[Int]
    assertThrows[Exception] {
      list.removeLast()
    }
    assert(list.isEmpty)
  }

  test("Delete from middle") {
    val list = new LinkedList[Int]
    list.add(1)
    list.add(2)
    list.add(3)
    val v = list.delete(1)
    assert(v == 2)

    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 3)
    assert(!iterator.hasNext)
  }

  test("Delete from end") {
    val list = new LinkedList[Int]
    list.add(1)
    list.add(2)
    list.add(3)
    val r = list.delete(2)
    assert(r == 3)

    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)
  }

  test("Delete from beginning") {
    val list = new LinkedList[Int]

    list.add(1)
    list.add(2)
    list.add(3)
    val r = list.delete(0)
    assert(r == 1)

    val iterator = list.iterator
    assert(iterator.next() == 2)
    assert(iterator.next() == 3)
    assert(!iterator.hasNext)
  }

  test("test find") {
    val list = new LinkedList[Int]

    list.add(1)
    list.add(2)
    list.add(3)

    assert(list.find(1))
    assert(list.find(2))
    assert(list.find(3))
    assert(!list.find(5))
  }

  test("test removeAfter") {
    val list = new LinkedList[Int]

    list.add(1)
    list.add(2)
    list.add(3)

    val node = list.first.next
    LinkedList.removeAfter(node)
    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)
  }

  test("test insert after") {
    val list = new LinkedList[Int]

    list.add(1)
    list.add(2)
    list.add(3)

    val list2 = new LinkedList[Int]
    list2.add(4)
    list2.add(5)

    LinkedList.insertAfter(list.first, list2.first)

    val iterator = list.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(iterator.next() == 3)
    assert(iterator.next() == 4)
    assert(iterator.next() == 5)
    assert(!iterator.hasNext)
  }

  test("test remove") {
    val list = new LinkedList[Int]

    list.add(1)
    list.add(2)
    list.add(1)
    list.add(3)
    list.add(1)

    list.remove(1)

    val iterator = list.iterator
    assert(iterator.next() == 2)
    assert(iterator.next() == 3)
    assert(!iterator.hasNext)
  }

  test("test max") {
    val list = new LinkedList[Int]

    list.add(-1)
    list.add(3)
    list.add(4)
    list.add(1)

    assert(list.max == 4)
  }

  test("test rec max") {
    val list = new LinkedList[Int]

    list.add(-1)
    list.add(3)
    list.add(4)
    list.add(1)

    assert(list.maxRec == 4)
  }

  test("Test reverse iterative") {
    val list = new LinkedList[Int]
    list.add(1)
    list.add(2)
    list.add(3)

    val reversed = LinkedList.reverseIterative(list)

    val iterator = reversed.iterator
    assert(iterator.next() == 3)
    assert(iterator.next() == 2)
    assert(iterator.next() == 1)
    assert(!iterator.hasNext)
  }

  test("test iterativ reverse one element") {
    val list = new LinkedList[Int]
    list.add(1)

    val reversed = LinkedList.reverseIterative(list)

    val iterator = reversed.iterator
    assert(iterator.next() == 1)
    assert(!iterator.hasNext)
  }

  test("test reverse iterative empty") {
    val list = new LinkedList[Int]
    assert(LinkedList.reverseIterative(list).isEmpty)
  }

  test("test reverse recursive ") {

    val list = new LinkedList[Int]
    list.add(1)
    list.add(2)
    list.add(3)

    val reversed = LinkedList.reverseRecursive(list)

    val iterator = reversed.iterator
    assert(iterator.next() == 3)
    assert(iterator.next() == 2)
    assert(iterator.next() == 1)
    assert(!iterator.hasNext)
  }

  test("test recursive one element") {
    val list = new LinkedList[Int]
    list.add(1)

    val reversed = LinkedList.reverseRecursive(list)

    val iterator = reversed.iterator
    assert(iterator.next() == 1)
    assert(!iterator.hasNext)
  }

  test("test reverse recursive empty") {
    val list = new LinkedList[Int]
    assert(LinkedList.reverseRecursive(list).isEmpty)
  }

  test("test insert in beginning") {
    val list = new LinkedList[Int]
    list.add(1)
    list.addFirst(2)

    val iterator: Iterator[Int] = list.iterator
    assert(iterator.next() == 2)
    assert(iterator.next() == 1)
    assert(!iterator.hasNext)
  }
}
