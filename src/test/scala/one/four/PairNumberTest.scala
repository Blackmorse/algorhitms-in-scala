package one.four

import org.scalatest.FunSuite

class PairNumberTest extends FunSuite {
  test("test 1") {
    val a = Array(1,2,1,3,1,2)

    assert(PairNumber.calculate(a) == 4)
  }
}
