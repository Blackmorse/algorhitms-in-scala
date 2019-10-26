package one.three

import org.scalatest.FunSuite

class MoveToFrontTest extends FunSuite {
  test("test") {
    val s = MoveToFront.doMove(Array("a", "b", "a", "c", "a"))
    val iterator = s.iterator

    assert(iterator.next() == "a")
    assert(iterator.next() == "c")
    assert(iterator.next() == "b")
    assert(!iterator.hasNext)
  }
}
