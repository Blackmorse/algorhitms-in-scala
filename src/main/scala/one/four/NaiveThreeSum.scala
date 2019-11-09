package one.four

object NaiveThreeSum {
  def count(a: Array[Int]): Int = {
    val n = a.length
    var count = 0
    for (i <- 0 until n; j <- 0 until n; k <- 0 until n if i < j && j < k) {
      if (a(i).toLong + a(j) + a(k) == 0) count += 1
    }
    count
  }

  def main(args: Array[String]): Unit = {
    DoublingTest.doTest(100, 7, count)
  }
}
