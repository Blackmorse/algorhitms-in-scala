package one.one

import org.scalatest.FunSuite

class BinarySearchTest extends FunSuite {
  test("test rank min 1") {
    val a = Array(0, 1, 2, 2, 2, 3)

    assert(BinarySearch.rankMin(2, a) == 2)
  }

  test("test rank min with distinct values") {
    val a = Array(0, 1, 2, 3, 4, 5)

    assert(BinarySearch.rankMin(3, a) == 3)
  }

  test("test rank min 2") {
    val a = Array(0, 0, 0, 1, 1, 2, 2, 2, 3, 3)

    assert(BinarySearch.rankMin(0, a) == 0)
    assert(BinarySearch.rankMin(1, a) == 3)
    assert(BinarySearch.rankMin(2, a) == 5)
    assert(BinarySearch.rankMin(3, a) == 8)
  }
}
