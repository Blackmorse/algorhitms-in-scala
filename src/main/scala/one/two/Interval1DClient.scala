package one.two

import edu.princeton.cs.algs4.{Interval1D, StdIn, StdRandom}

object Interval1DClient {
  def main(args: Array[String]): Unit = {

    val n = StdIn.readInt()

//    val intervals = 1.to(n).map(_ => new Interval1D(StdIn.readDouble(), StdIn.readDouble()))
    val intervals = 1.to(n).map(_ => Seq.fill(2)(StdRandom.uniform()))
      .map(s => new Interval1D(s.min, s.max))


    intervals.view.flatMap(interval => intervals.map(interval2 => (interval, interval2))).filter(t => !t._1.eq(t._2))
      .filter(t => t._1.intersects(t._2)).foreach(println)

  }
}
