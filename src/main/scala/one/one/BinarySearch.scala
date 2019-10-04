package one.one

import java.util

import help.Helper

object BinarySearch {

  def main(args: Array[String]): Unit = {
    val a = Helper.randomArray(63, 0, 100)
    util.Arrays.sort(a)
    a.zipWithIndex.map(_.swap).foreach(println)
    println(rankRec(44, a))
  }

  def rank(key: Int, a: Array[Int]): Int = {
    var lo = 0
    var hi = a.length - 1
    while (lo <= hi) {
      val mid = lo + (hi - lo) / 2
      if (key < a(mid)) hi = mid - 1
      else if (key > a(mid)) lo = mid + 1
      else return mid
    }
    -1
  }

  def rankRec(key: Int, a: Array[Int]): Int = {
    doRankRec(key, a, 0, a.length - 1, 0)
  }

  private def doRankRec(key: Int, a: Array[Int], lo: Int, hi: Int, recDepth: Int): Int = {
    val tab = "  " * recDepth;
    println(s"${tab}lo: $lo, hi: $hi")
    if (lo > hi) return -1
    val mid = lo + (hi - lo) / 2
    if (key < a(mid)) doRankRec(key, a, lo, mid - 1, recDepth + 1)
    else if (key > a(mid)) doRankRec(key, a, mid + 1, hi, recDepth + 1)
    else mid
  }
}
