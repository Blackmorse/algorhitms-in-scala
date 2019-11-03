package one.four

import org.scalatest.FunSuite

class StaticSetOfIntsTest extends FunSuite {
  test("test howMuch") {
    val a = Array(0, 1, 2, 2, 3, 3, 3)

    val set = new StaticSetOfInts(a)

    assert(set.howMuch(0) == 1)
    assert(set.howMuch(1) == 1)
    assert(set.howMuch(4) == 0)
    assert(set.howMuch(2) == 2)
    assert(set.howMuch(3) == 3)
  }

  test("test howMuch2") {
    val a = Array(0, 1, 2, 2, 3, 3, 3)

    val set = new StaticSetOfInts(a)

    assert(set.howMuch2(0) == 1)
    assert(set.howMuch2(1) == 1)
    assert(set.howMuch2(4) == 0)
    assert(set.howMuch2(2) == 2)
    assert(set.howMuch2(3) == 3)
  }
}
