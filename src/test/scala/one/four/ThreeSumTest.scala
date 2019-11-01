package one.four

import org.scalatest.FunSuite

class ThreeSumTest extends FunSuite {
  test("test four numbers") {
    val a = Array(1, 2, 3, -4)
    assert(ThreeSum.count(a) == 1)
  }

  test("test integer overflow") {
    val a = Array(Int.MaxValue - 1, Int.MaxValue - 1, 4)
    assert(ThreeSum.count(a) == 0)
  }
}
