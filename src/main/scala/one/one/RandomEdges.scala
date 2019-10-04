package one.one

import edu.princeton.cs.algs4.{StdDraw, StdIn, StdRandom}



object RandomEdges {

  def main(args: Array[String]): Unit = {
    StdDraw.circle(0.5, 0.5, 0.5)

    val N = StdIn.readInt()
    val p = StdIn.readDouble()

    StdDraw.setPenRadius(0.05)

    val points = for (_ <-1 to N) yield drawPoint(0.5, 0.5, 0.5)

    StdDraw.setPenRadius()
    StdDraw.setPenColor(StdDraw.GRAY)

    for (point1 <- points; point2 <- points) {
      if (StdRandom.bernoulli(p)) {
        StdDraw.line(point1._1, point1._2, point2._1, point2._2)
      }
    }
  }

  private def drawPoint(circleRadius: Double, circleX: Double, circleY: Double): (Double, Double) = {

    val (x,y) = LazyList.continually(((StdRandom.uniform() -0.5) * circleRadius * 2, (StdRandom.uniform() - 0.5) * circleRadius * 2))
      .dropWhile({case (x, y) => (x*x + y*y) > circleRadius * circleRadius}).take(1).head


    StdDraw.point(x + circleX, y + circleY)

    (x + circleX, y + circleY)
  }10
}
