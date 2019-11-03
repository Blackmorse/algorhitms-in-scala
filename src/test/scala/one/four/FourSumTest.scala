package one.four

import java.util

import org.scalatest.FunSuite

class FourSumTest extends FunSuite {
  test("test four sum") {
    val a = Array(1, 2, 3, 4, -4, -1)
    util.Arrays.sort(a)
    assert(FourSum.count(a) == 2)
  }
}
