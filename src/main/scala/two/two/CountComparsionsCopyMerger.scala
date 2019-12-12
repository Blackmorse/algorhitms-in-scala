package two.two

import java.awt.Color

import common.Plot
import edu.princeton.cs.algs4.StdRandom

import scala.collection.mutable

trait CountComparsionsCopyMerger[T] extends Merger[T] {
  this: MergeSort[T] =>
  var comparsions = 0

  protected def merge(arr: Array[T], lo: Int, mid: Int, hi: Int, copyArray: Array[T]): Unit = {
    comparsions += 1
    if(arr(mid) < arr(mid + 1)) {
      return
    }
    (lo to hi).foreach(i => copyArray(i) = arr(i))

    var leftIndex = lo
    var rightIndex = mid + 1

    for (i <- lo to hi) {
      if (leftIndex > mid)  {arr(i) = copyArray(rightIndex); rightIndex += 1}
      else if(rightIndex > hi) {arr(i) = copyArray(leftIndex); leftIndex += 1}
      else if (copyArray(rightIndex) > copyArray(leftIndex)) {arr(i) = copyArray(leftIndex); leftIndex += 1; comparsions += 1}
      else  {arr(i) = copyArray(rightIndex); rightIndex += 1; comparsions += 1}
    }
  }
}

object CountComparsionsCopyMerger {
  def main(args: Array[String]): Unit = {
    val topDown = new TopDownMergeSort[Double]() with CountComparsionsCopyMerger[Double]
    val bottomUp = new BottomUpMergeSort[Double]() with CountComparsionsCopyMerger[Double]

    val topDownData = mutable.Buffer[(Double, Double)]()
    val bottomUpData = mutable.Buffer[(Double, Double)]()

    val logData = mutable.Buffer[(Double, Double)]()

    for (n <- 1 to 512) {
      topDown.comparsions = 0
      bottomUp.comparsions = 0

      val a = Array.fill(n)(StdRandom.uniform())

      topDown.sort(a)
      topDownData += ((n.toDouble, topDown.comparsions.toDouble))

      bottomUp.sort(a)
      bottomUpData += ((n.toDouble, bottomUp.comparsions.toDouble))

//      logData += ((n.toDouble, 6 * n ))
    }

    new Plot()
      .addChart(topDownData.toSeq, Color.RED)
      .addChart(bottomUpData.toSeq, Color.GREEN)
//      .addChart(logData.toSeq, Color.BLACK)
      .dots()
      .draw

  }
}
