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

  test("test rank max") {
    val a = Array(0, 1, 2, 2, 2, 3)

    assert(BinarySearch.rankMax(2, a) == 4)
  }

  test("test rank max with distinct values") {
    val a = Array(0, 1, 2, 3, 4, 5)

    assert(BinarySearch.rankMax(3, a) == 3)
  }

  test("test rank max 2") {
    val a = Array(0, 0, 0, 1, 1, 2, 2, 2, 3, 3)

    assert(BinarySearch.rankMax(0, a) == 2)
    assert(BinarySearch.rankMax(1, a) == 4)
    assert(BinarySearch.rankMax(2, a) == 7)
    assert(BinarySearch.rankMax(3, a) == 9)
  }
}
