package two.two

import one.one.BinarySearch
import two.two.improved.{ImprovedMergeSortWithInsertion, ImprovedMergerWithComparsion}

import scala.reflect.ClassTag

object IndirectSort {
  def indirectSort[T: ClassTag](a: Array[T])(implicit ord: T => Ordered[T]) : Array[Int] = {
    val sorter = new ImprovedMergeSortWithInsertion[T]() with ImprovedMergerWithComparsion[T]

    val clone = a.clone()

    sorter.sort(a)

    val res = Array.fill(a.length)(0)

    for (i <- a.indices) {
      val el = clone(i)
      val index = BinarySearch.rank(el, a, 0, a.length - 1)
      res(index) = i
    }

    res
  }
}
