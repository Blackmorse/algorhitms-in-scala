package one.one

import help.Helper

object BruteForceSearch {
  def search(a: Array[Int], key: Int): Int = {
    for (i <- a.indices) {
      if (a(i) == key) return i
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val array = Helper.readIntsFromFile("")
    val sorted = array.sorted

    println(sorted.size)

    val t1 = System.currentTimeMillis()
    search(sorted, 100)
    val t2 = System.currentTimeMillis()
    println(s"Brute: ${t2-t1}")

    val t3 = System.currentTimeMillis()
    BinarySearch.rank(100, sorted)
    val t4 = System.currentTimeMillis()
    println(s"binary: ${t4-t3}")
  }
}
