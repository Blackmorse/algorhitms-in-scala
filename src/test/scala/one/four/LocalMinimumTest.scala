package one.four

import org.scalatest.FunSuite

class LocalMinimumTest extends FunSuite {
  test("test minimum in the middle") {
    val a = Array(3, 2, 1, 4, 5)
    assert(LocalMinimum.arrayMinimum(a) == 2)
  }

  test("test minimum in the left part") {
    val a = Array(4, 1, 3, 5, 7, 9)
    assert(LocalMinimum.arrayMinimum(a) == 1)
  }

  test("test minimum in the right part") {
    val a = Array(7,6,5,4,3,2,3)
    assert(LocalMinimum.arrayMinimum(a) == 5)
  }

  test("test minimum at left element") {
    val a = Array(1,2,3,4,5,6)
    assert(LocalMinimum.arrayMinimum(a) == 0)
  }

  test("test minimum at right element") {
    val a = Array(6,5,4,3,2,1,0)
    assert(LocalMinimum.arrayMinimum(a) == 6)
  }
}
