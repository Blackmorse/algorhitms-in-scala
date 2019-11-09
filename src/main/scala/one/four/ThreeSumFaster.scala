package one.four

import java.util

object ThreeSumFaster {
  def count(a: Array[Int]): Int = {
    util.Arrays.sort(a)
    var count = 0
    for (i <- 0 until a.length - 2) {
      count += TwoSumFaster.count(a, a(i), i+1)
    }
    count
  }

  def main(args: Array[String]): Unit = {
    DoublingTest.doTest(500, 9, count, testNumber = 5)
  }
}

