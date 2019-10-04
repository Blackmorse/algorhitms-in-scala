package one.one

import java.awt.Color

import edu.princeton.cs.algs4.{StdDraw, StdIn, StdRandom}

import scala.collection.mutable

object Histogram {
  def main(args: Array[String]): Unit = {
    val N = StdIn.readInt()
    val l = StdIn.readDouble()
    val r = StdIn.readDouble()

    val intervalLength = (r - l) / N

    val intervals = 0.until(N).map(i => (l + (r - l) * i / N, l + (r - l) * (i + 1) / N))

    val intervalCounts = mutable.Buffer.fill(N)(0)

    for (i <- 1 to 10000) {
      val v = StdRandom.uniform()
      if (v >= l && v <= r) {
        val intervalNumber = ((v - l) / intervalLength).toInt
        val count = intervalCounts(intervalNumber)
        intervalCounts(intervalNumber) = count + 1
      }
    }
    val scale = 1.toDouble / intervalCounts.max

    intervalCounts.zip(intervals).foreach({case(count, (xl, xr)) => drawRect(xl, 0, intervalLength, count * scale)})
  }



  def drawRect(x: Double, y: Double, width: Double, height: Double) = {
    StdDraw.setPenColor(new Color(70 + StdRandom.uniform(105), 70 + StdRandom.uniform(105), 70 + StdRandom.uniform(105)))

    StdDraw.filledRectangle(x + width / 2, y + height / 2, width / 2, height / 2)
  }
}
