package one.four

import one.one.Main

object TwoSumFaster {
  def count(a: Array[Int], initialNumber: Int = 0, fromIndex: Int = 0): Int = {
    var leftIndex = fromIndex
    var rightIndex = a.length - 1

    var count = 0

    while(leftIndex < rightIndex) {
      if (initialNumber + a(leftIndex) + a(rightIndex) > 0) {
        rightIndex -= 1
      } else if (initialNumber + a(leftIndex) + a(rightIndex) < 0) {
        leftIndex += 1
      } else {
        if (a(leftIndex) == a(rightIndex)) {
          val n = rightIndex - leftIndex + 1
          count += Main.bin(n, 2).toInt
          return count
        } else {
          var leftCount = 1
          var rightCount = 1

          while (leftIndex < rightIndex && a(leftIndex) == a(leftIndex + 1)) {
            leftIndex += 1
            leftCount += 1
          }

          while (leftIndex < rightIndex && a(rightIndex) == a(rightIndex - 1)) {
            rightIndex -= 1
            rightCount += 1
          }

          count += leftCount * rightCount

          leftIndex += 1
        }
      }
    }
    count
  }

  def main(args: Array[String]): Unit = {
    DoublingTest.doTest(10000000, 6, count(_, 0, 0))
  }
}
