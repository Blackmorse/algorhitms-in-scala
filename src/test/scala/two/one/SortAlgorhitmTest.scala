package two.one

import edu.princeton.cs.algs4.StdRandom
import org.scalatest.{BeforeAndAfter, FunSuite}

abstract class SortAlgorhitmTest extends FunSuite with BeforeAndAfter {
  var sorter: SortAlgorhitm[Int] = _

  test("test simple") {
    val a = Array(3, 5,1,0, 7, 9)
    sorter.sort(a)
    a.foreach(println)

    assert(a sameElements Array(0, 1, 3, 5, 7, 9))
    assert(sorter.isSorted(a))
  }

  test("test Random") {
    val a = Array.fill(100)(0)
    for  (i <- a.indices) a(i) = StdRandom.uniform(1000000)

    sorter.sort(a)
    assert(sorter.isSorted(a))
  }
}
