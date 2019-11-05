package one.four

import one.one.BinarySearch

object BitonicSearch {
  /**
    * works only with Bitonic arrays
    */
  def contains(key: Int, a: Array[Int]): Boolean = {
    val maximum = LocalMinimumAndMaximum.arrayMaximum(a)
    BinarySearch.rank(key, a, 0, maximum) != -1 || BinarySearch.rankInverse(key, a, maximum) != -1
  }
}
