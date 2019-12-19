package two.two.kmerge

import org.scalatest.{BeforeAndAfter, FunSuite}

class KCopyMergerTest extends FunSuite with BeforeAndAfter {
  val merger = new KCopyMerger[Int]()


  test("2merge for 2 elements") {
    val a = Array(2, 1)
    merger.merge(0, 2, 1, a, a.clone())

    assert(a sameElements Array(1, 2))
  }

  test("4merge for 4 elements") {
    val a = Array(4,3,2,1)
    merger.merge(0, 4, 1, a, a.clone())

    assert(a sameElements Array(1,2,3,4))
  }

  test("3merge for 3 elements") {
    val a = Array(3,2,1)

    merger.merge(0, 3, 1, a, a.clone())

    assert(a sameElements Array(1,2,3))
  }

  test("3merge for 9 elements") {
    val a = Array(7,8,9, 4,5,6, 1,2,3)

    merger.merge(0, 3, 3, a, a.clone())

    assert(a sameElements Array(1,2,3,4,5,6,7,8,9))
  }

  test("3merge for 8 elements") {
    val a = Array(6,7,8,9, 4,5,6, 1,2)

    merger.merge(1, 3, 3, a, a.clone())

    assert(a sameElements Array(6,1,2,4,5,6,7,8,9))
  }

  test("2merge for 3 elements") {
    val a = Array(2,3,1)

    merger.merge(0, 2, 2, a, a.clone())

    assert(a sameElements Array(1,2,3))
  }

  test("3merge for 16 elements") {
    val a = (1 to 16).toArray

    merger.merge(0, 3, 3, a, a.clone())

    val array = (1 to 16).toArray
    assert(a sameElements array)
  }
}
