package two.two

import org.scalatest.FunSuite

class InversionsTest extends FunSuite {
  test("test 1") {
    val a = Array(2,3,4,5,8,7,6)

    assert(Inversions.inversions(a) == 2)
  }

  test("test 2") {
    val a = Array(2,3,4,5,6,7,8,9,1)

    assert(Inversions.inversions(a) == 9)
  }
}
