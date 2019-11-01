package one.four

object ThreeSum {
  def count(a: Array[Int]): Int = {
    val n = a.length
    var count = 0
    for (i <- 0 until n; j <- i+1 until n; k <- j+1 until n) {
      if (a(i).toLong + a(j) + a(k) == 0) count += 1
    }
    count
  }
}
