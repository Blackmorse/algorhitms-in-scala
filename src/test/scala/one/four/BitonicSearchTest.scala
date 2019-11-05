package one.four

import org.scalatest.FunSuite

class BitonicSearchTest extends FunSuite {
  test("Test array doesn't contain") {
    val a = Array(1, 3, 5, 7, 6, 4)
    val bool = BitonicSearch.contains(2, a)
    assert(!bool)
  }

  test("test element in maximum") {
    val a = Array(1, 3, 5, 7, 9, 8, 6, 4, 2, 0)
    assert(BitonicSearch.contains(9, a))
  }

  test("test element in left/right part") {
    val a = Array(1, 3, 5, 7, 9, 8, 6, 4, 2, 0)
    val bool = BitonicSearch.contains(2, a)
    assert(BitonicSearch.contains(3, a))

    assert(bool)
  }

  test("test element at beginning/end") {
    val a = Array(1,3,5,7,9,8,6,4,2,0)
    assert(BitonicSearch.contains(1, a))
    assert(BitonicSearch.contains(0, a))
  }
}
