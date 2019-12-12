package two.two

import java.awt.Color

import common.Plot
import edu.princeton.cs.algs4.StdRandom

import scala.collection.mutable

trait CountAccessesCopyMerger[T] extends Merger[T] {
  this: MergeSort[T] =>
  var accesses = 0

  protected def merge(arr: Array[T], lo: Int, mid: Int, hi: Int, copyArray: Array[T]): Unit = {
    (lo to hi).foreach(i => { copyArray(i) = arr(i); accesses +=2 })

    var leftIndex = lo
    var rightIndex = mid + 1

    for (i <- lo to hi) {
      if (leftIndex > mid)  {arr(i) = copyArray(rightIndex); rightIndex += 1; accesses += 2}
      else if(rightIndex > hi) {arr(i) = copyArray(leftIndex); leftIndex += 1; accesses += 2}
      else if (copyArray(rightIndex) > copyArray(leftIndex)) {arr(i) = copyArray(leftIndex); leftIndex += 1; accesses += 4}
      else  {arr(i) = copyArray(rightIndex); rightIndex += 1; accesses += 2}
    }
  }
}

object CountAccessesCopyMerger {
  def main(args: Array[String]): Unit = {
    val topDown = new TopDownMergeSort[Double]() with CountAccessesCopyMerger[Double]
    val bottomUp = new BottomUpMergeSort[Double]() with CountAccessesCopyMerger[Double]

    val topDownData = mutable.Buffer[(Double, Double)]()
    val bottomUpData = mutable.Buffer[(Double, Double)]()

    val logData = mutable.Buffer[(Double, Double)]()

    for (n <- 1 to 512) {
      topDown.accesses = 0
      bottomUp.accesses = 0

      val a = Array.fill(n)(StdRandom.uniform())

      topDown.sort(a)
      topDownData += ((n.toDouble, topDown.accesses.toDouble))

      bottomUp.sort(a)
      bottomUpData += ((n.toDouble, bottomUp.accesses.toDouble))

      logData += ((n.toDouble, 6 * n * Math.log(n)))
    }

    new Plot()
      .addChart(topDownData.toSeq, Color.RED)
      .addChart(bottomUpData.toSeq, Color.GREEN)
      .addChart(logData.toSeq, Color.BLACK)
      .dots()
      .draw

  }
}
