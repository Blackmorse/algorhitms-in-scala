package one.three

import org.scalatest.FunSuite

class JosephusTest extends FunSuite {
  test("test josef") {
    val res = Josephus.doJosef(7, 2)
    assert(res sameElements Array(1, 3, 5, 0, 4, 2, 6))
  }
}
