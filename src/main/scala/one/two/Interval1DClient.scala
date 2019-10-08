package one.two

import edu.princeton.cs.algs4.{Interval1D, StdIn, StdRandom}
import help.Helper

object Interval1DClient {
  def main(args: Array[String]): Unit = {

    val n = StdIn.readInt()

//    val intervals = 1.to(n).map(_ => new Interval1D(StdIn.readDouble(), StdIn.readDouble()))
    val intervals = 1.to(n).map(_ => Seq.fill(2)(StdRandom.uniform()))
      .map(s => new Interval1D(s.min, s.max))


    Helper.distinctCartesian(intervals)
      .filter(t => t._1.intersects(t._2)).foreach(println)

  }
}
