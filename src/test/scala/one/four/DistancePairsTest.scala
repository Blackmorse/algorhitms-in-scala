package one.four

import org.scalatest.FunSuite

class DistancePairsTest extends FunSuite {
  test("test closest and farthest") {
    val a = Array(0.0, -3.0, 5.0, -3.1)
    assert(DistancePairs.closest(a) == (-3.1, -3.0))
    assert(DistancePairs.farthest(a) == (-3.1, 5.0))
  }
}
