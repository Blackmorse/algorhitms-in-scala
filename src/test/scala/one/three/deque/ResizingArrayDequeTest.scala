package one.three.deque

import org.scalatest.{BeforeAndAfter, FunSuite}

class ResizingArrayDequeTest extends FunSuite with BeforeAndAfter{
  var deque: ResizingArrayDeque[Int] = _

  before {
    deque = new ResizingArrayDeque[Int]
  }

  test("Test push left") {
    deque.pushLeft(1)
    deque.pushLeft(2)

    val iterator = deque.iterator
    assert(iterator.next() == 2)
    assert(iterator.next() == 1)
    assert(!iterator.hasNext)
  }

  test("Test push right") {
    deque.pushRight(1)
    deque.pushRight(2)

    val iterator = deque.iterator
    assert(iterator.next() == 1)
    assert(iterator.next() == 2)
    assert(!iterator.hasNext)
  }

  test("test push left and pop left") {
    deque.pushLeft(1)
    deque.pushLeft(2)

    assert(deque.popLeft() == 2)
    assert(deque.popLeft() == 1)
  }

  test("test push and pop right") {
    deque.pushRight(1)
    deque.pushRight(2)

    assert(deque.popRight() == 2)
    assert(deque.popRight() == 1)
  }

  test("test push left and pop right") {
    deque.pushLeft(1)
    deque.pushLeft(2)

    assert(deque.popRight() == 1)
    assert(deque.popRight() == 2)
  }

  test("test push right and pop left") {
    deque.pushRight(1)
    deque.pushRight(2)
    deque.pushRight(3)

    assert(deque.popLeft() == 1)
    assert(deque.popLeft() == 2)
    assert(deque.popLeft() == 3)
  }

  test("mix sides") {
    deque.pushLeft(1)
    deque.pushLeft(2)
    deque.pushRight(3)
    deque.pushRight(4)

    assert(deque.popLeft() == 2)
    assert(deque.popRight() == 4)
    assert(deque.popRight() == 3)
    assert(deque.popRight() == 1)
  }

  test("pop left empty") {
    assertThrows[IllegalArgumentException] {
      deque.popLeft()
    }
  }

  test("push right and too many left popps") {
    deque.pushRight(1)

    assert(deque.popLeft() == 1)
    assertThrows[IllegalArgumentException] {
      deque.popLeft()
    }
  }

  test("pop right empty") {
    assertThrows[IllegalArgumentException] {
      deque.popRight()
    }
  }

  test("push left and too many right pops") {
    deque.pushLeft(1)

    assert(deque.popRight() == 1)
    assertThrows[IllegalArgumentException] {
      deque.popRight()
    }
  }

  test("test increase left") {
    1 to 10 foreach (deque.pushLeft(_))

    (1 to 10).reverse foreach (i => assert(deque.popLeft() == i))
  }

  test("test push right and increase left") {
    deque.pushRight(-1)

    1 to 10 foreach (deque.pushLeft(_))

    (1 to 10).reverse foreach (i => assert(deque.popLeft() == i))
    assert(deque.popLeft() == -1)
  }

  test("test increase right") {
    1 to 10 foreach (deque.pushRight(_))
    (1 to 10).reverse foreach (i => assert(deque.popRight() == i))
  }

  test("test increase left and right and pop right") {
    1 to 10 foreach (deque.pushRight(_))
    -10 to -1 foreach (deque.pushLeft(_))

    (1 to 10).reverse foreach(i => assert(deque.popRight() == i))
    -10 to -1 foreach (i => assert(deque.popRight() == i))
  }

  test("test decrease left") {
    1 to 100 foreach (deque.pushLeft(_))
    (1 to 100).reverse foreach(i => assert(deque.popLeft() == i))
  }

  test("test decrease right") {
    1 to 100 foreach (deque.pushRight(_))
    (1 to 100).reverse foreach (i => assert(deque.popRight() == i))
  }

  test("test all :)") {
    (1 to 1000) foreach (deque.pushLeft(_))
    (-1000 to -1) foreach (deque.pushRight(_))

    (1 to 1000).reverse foreach(i => assert(deque.popLeft() == i))
    -1000 to -100 foreach (i => assert(deque.popLeft() == i))

    (-99 to -1).reverse foreach(i => assert(deque.popRight() == i))

    assert(deque.isEmpty)
  }
}
