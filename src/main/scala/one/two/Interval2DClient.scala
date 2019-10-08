package one.two

import edu.princeton.cs.algs4._
import help.Helper

object Interval2DClient {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val min = StdIn.readDouble()
    val max = StdIn.readDouble()

    assert(min >= 0d && max <= 1)

    val intervals  = 1.to(n).map(_ => (generateInterval(min, max), generateInterval(min, max)))

    val containingIntervals = Helper.cartesianProduct(intervals).filter(t => !t._1.eq(t._2)).filter(t => contains(t._1, t._2))
    println(s"Containing: ${containingIntervals.size}")

    val intersectionIntervals = Helper.distinctCartesian(intervals)
      .map(t => (new Interval2D(t._1._1, t._1._2), new Interval2D(t._2._1, t._2._1)))
      .filter(t => t._1.intersects(t._2))

    println(s"Intersections: ${intersectionIntervals.size}")

    StdDraw.setPenColor(StdDraw.BLUE)
    StdDraw.setPenRadius(0.003)

    containingIntervals.map(t => new Interval2D(t._2._1, t._2._2)).foreach(_.draw())

    StdDraw.setPenColor(StdDraw.BLACK)
    StdDraw.setPenRadius(0.002)

    intervals.map(t => new Interval2D(t._1, t._2)).foreach(_.draw())

  }

  def generateInterval(min: Double, max: Double): Interval1D = {
    val a = StdRandom.uniform(min, max)
    val b = StdRandom.uniform(min, max)

    if (a > b) new Interval1D(b, a) else new Interval1D(a, b)
  }

  /**
  first interval contains second interval
   **/
  def contains(i1: (Interval1D, Interval1D), i2: (Interval1D, Interval1D)): Boolean = {
    i1._1.contains(i2._1.min()) && i1._1.contains(i2._1.max()) && i1._2.contains(i2._2.min()) && i1._2.contains(i2._2.max())
  }
}
