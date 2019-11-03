package one.four

import org.scalatest.FunSuite

class SortedArraysIntersectionTest extends FunSuite {
  test("test arrays") {
    val a1 = Array(1, 2, 3, 4)
    val a2 = Array(2, 4, 5, 6)

    val ints = SortedArraysIntersection.intersection(a1, a2)
    assert(ints sameElements Array(2, 4))
  }

  test("test different sizes") {
    val a1 = Array(1, 3, 5, 7)
    val a2 = Array(3)

    val ints = SortedArraysIntersection.intersection(a1, a2)
    assert(ints sameElements Array(3))
  }

  test("test different sizes inverse") {
    val a1 = Array(3)
    val a2 = Array(1, 3, 5, 7)

    val ints = SortedArraysIntersection.intersection(a1, a2)
    assert(ints sameElements Array(3))
  }

  test("test 1-size arrays") {
    val a1 = Array(1)
    val a2 = Array(1)

    assert(SortedArraysIntersection.intersection(a1, a2) sameElements Array(1))
  }

  test("test no intersection") {
    val a1 = Array(1, 3, 5, 7)
    val a2 = Array(2, 4, 6)

    assert(SortedArraysIntersection.intersection(a1, a2).isEmpty)
  }
}
