package one.four

import one.one.BinarySearch

object FourSum {
  def count(a: Array[Int]): Int = {
    val n = a.length
    var count = 0
    for(i <- 0 until n; j <- i+1 until n; k <- j+1 until n) {
      val v = a(i).toLong + a(j).toLong + a(k).toLong
      if (BinarySearch.rank(-v.toInt, a) > k) {
        count += 1
      }
    }
    count
  }
}
