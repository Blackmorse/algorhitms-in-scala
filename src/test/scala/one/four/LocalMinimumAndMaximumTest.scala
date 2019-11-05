package one.four

import org.scalatest.FunSuite

class LocalMinimumAndMaximumTest extends FunSuite {
  test("test extreme in the middle") {
    val a = Array(3, 2, 1, 4, 5)
    assert(LocalMinimumAndMaximum.arrayMinimum(a) == 2)
    assert(LocalMinimumAndMaximum.arrayMaximum(a.map(-_)) == 2)
  }

  test("test extreme in the left part") {
    val a = Array(4, 1, 3, 5, 7, 9)
    assert(LocalMinimumAndMaximum.arrayMinimum(a) == 1)
    assert(LocalMinimumAndMaximum.arrayMaximum(a.map(-_)) == 1)
  }

  test("test extreme in the right part") {
    val a = Array(7,6,5,4,3,2,3)
    assert(LocalMinimumAndMaximum.arrayMinimum(a) == 5)
    assert(LocalMinimumAndMaximum.arrayMaximum(a.map(-_)) == 5)
  }

  test("test extreme at left element") {
    val a = Array(1,2,3,4,5,6)
    assert(LocalMinimumAndMaximum.arrayMinimum(a) == 0)
    assert(LocalMinimumAndMaximum.arrayMaximum(a.map(-_)) == 0)
  }

  test("test extreme at right element") {
    val a = Array(6,5,4,3,2,1,0)
    assert(LocalMinimumAndMaximum.arrayMinimum(a) == 6)
    assert(LocalMinimumAndMaximum.arrayMaximum(a.map(-_)) == 6)
  }

  test("test extreme in middle 2") {
    val a = Array(1, 3, 5, 7, 6, 4)
    assert(LocalMinimumAndMaximum.arrayMaximum(a) == 3)
    assert(LocalMinimumAndMaximum.arrayMinimum(a.map(-_)) == 3)
  }
}
