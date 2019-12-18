package two.two

import org.scalatest.FunSuite

class IndirectSortTest extends FunSuite {
  test( "test") {
    val a = Array(5,3,4,6,2,1)

    val res = IndirectSort.indirectSort(a)

    assert(Array(5, 4, 1, 2, 0, 3) sameElements res)
  }
}
