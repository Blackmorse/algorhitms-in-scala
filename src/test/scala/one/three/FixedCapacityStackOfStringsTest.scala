package one.three

import org.scalatest.FunSuite

class FixedCapacityStackOfStringsTest extends FunSuite {
  test("test is full") {
    val stack = new FixedCapacityStackOfStrings(2)
    stack.push("1")
    assert(!stack.isFull)

    stack.push("2")
    assert(stack.isFull)

    stack.pop
    assert(!stack.isFull)
  }
}
