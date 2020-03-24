package scala.two.three

import two.one.tools.UniformArrayGenerator
import two.three.QuickSort

import scala.collection.mutable
import scala.common.Histogram

object SortingTimesHistogram {
  def main(args: Array[String]): Unit = {
    val generator = UniformArrayGenerator

    val sorter = new QuickSort[Double]()

    val n = 1000000
    val t = 100

    val times = mutable.Buffer[Int]()

    for (i <- 1 to t + 3) {

      val arr = generator.generate(n)

      val start = System.currentTimeMillis()
      sorter.sort(arr)
      if (i >= 3) times += (System.currentTimeMillis() - start).toInt
    }

    Histogram.draw(times.toSeq)
  }
}
