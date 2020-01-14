package two.three

import org.scalatest.FunSuite

class TwoDistinctSortTest extends FunSuite {
  test("test 2 distinct") {
    val a = Array(1,2,2,1,2,2,2,1,2)
    TwoDistinctSort.sort(a)
    assert(a.sorted sameElements a)
  }
}
