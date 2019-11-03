package one.four

import org.scalatest.FunSuite

class TwoSumFasterTest extends FunSuite {
  test("test two sum") {
    val a = Array(-3, -1, 1, 3)
    assert(TwoSumFaster.count(a) == 2)
  }

  test("test repeated numbers") {
    val a = Array(-3, -3, -1, 1, 3, 3, 3)
    val count = TwoSumFaster.count(a)
    assert(count == 7)
  }

  test("test with one zero") {
    val a = Array(-3, -1, 0, 1, 3)
    assert(TwoSumFaster.count(a) == 2)
  }

  test("test with several zeros") {
    val a = Array(-3, 0, 0 ,0 ,0 , 1)
    assert(TwoSumFaster.count(a) == 6)
  }
}
