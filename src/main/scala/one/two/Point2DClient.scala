package one.two

import edu.princeton.cs.algs4.{Point2D, StdDraw, StdIn, StdRandom}

object Point2DClient {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val points = for (_ <- 1 to n) yield generatePoint()

    StdDraw.setPenRadius(0.03)

    points.foreach(_.draw())

    val res = points.view.flatMap(point1 => points.map(point2 => (point1, point2))).filter({case (p1, p2) => !p1.eq(p2)})
      .minBy({case (p1, p2) => p1.distanceTo(p2)})

    println(res)

    StdDraw.setPenColor(StdDraw.RED)

    res._1.draw()
    res._2.draw()
  }

  def generatePoint(): Point2D = {
    val edge = StdRandom.uniform(4)
    val d: Double = StdRandom.uniform()
    val (x, y) = edge match {
      case 0 => (0d, d)
      case 1 => (d, 1d)
      case 2 => (1d, d)
      case 3 => (d, 0d)
      case _ => throw new IllegalArgumentException
    }
    new Point2D(x, y)
  }
}
