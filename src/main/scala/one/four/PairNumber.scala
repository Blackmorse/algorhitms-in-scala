package one.four

import java.util

import one.one.Main

object PairNumber {

  def calculate(a: Array[Int]): Int = {
    util.Arrays.sort(a)
//    var lastElement = a(0)
    var sameElements = 0
    var count = 0

    for (i <- 1 until a.length) {
      if (a(i - 1) == a(i)) {
        if (sameElements == 0) sameElements = 2
        else sameElements += 1
      } else {
        if (sameElements > 0) {
          count += bin(sameElements, 2).toInt
          sameElements = 0
        }
      }
    }

    if (sameElements > 0) {
      count += bin(sameElements, 2).toInt
    }

    count
  }

  def bin(n: Int, k: Int): Long = {
    Main.fact(n) / (Main.fact(n - k) * Main.fact(k))
  }

  def main(args: Array[String]): Unit = {
    DoublingTest.doTest(100000, 11, calculate, true)
  }
}
