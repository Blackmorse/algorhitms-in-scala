package one.three

import org.scalatest.FunSuite

class StequeTest extends FunSuite {
  test("test stack behaviour") {
    val steque = new Steque[Int]
    steque.push(1)
    steque.push(2)
    steque.push(3)
    assert(steque.pop() == 3)
    assert(steque.pop() == 2)
    assert(steque.pop() == 1)

    assert(!steque.iterator.hasNext)
  }

  test("test enqueue") {
    val steque = new Steque[Int]
    steque.push(1)
    steque.push(2)
    steque.enqueue(3)

    assert(steque.pop() == 2)
    assert(steque.pop() == 1)
    assert(steque.pop() == 3)
    assert(!steque.iterator.hasNext)
  }
}
