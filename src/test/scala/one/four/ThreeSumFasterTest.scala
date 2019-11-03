package one.four

import org.scalatest.FunSuite

class ThreeSumFasterTest extends FunSuite {
  test("test ") {
    val a = Array(-3, -2, 1, 1)
    val count = ThreeSumFaster.count(a)
    assert(count == 1)
  }

  test("test same elements") {
    val a = Array(-8, 2, 3, 4, 4, 4, 4, 5, 6)
    val count = ThreeSumFaster.count(a)
    assert(count == 8)
  }

  test("test 2") {
    val a = Array(-4,-3,-2,1,1,3,5)
    val count = ThreeSumFaster.count(a)
    assert(count == 4)
  }
}
