package one.four

import edu.princeton.cs.algs4.{StdDraw, StdRandom, Stopwatch}

import scala.collection.mutable

object DoublingTest {
  private val MAXIMUM_INTEGER = 1000000

  def timeTrial(n: Int): Double = {
    val a = Array.fill(n)(0).map(_ => StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER))
    val timer = new Stopwatch()
    ThreeSum.count(a)
    timer.elapsedTime()
  }

  def main(args: Array[String]): Unit = {
    var n = 125
    val data = mutable.Buffer[(Int, Double)]()
    for (i <- 1 to 6) {
      n += n
      val time = timeTrial(n)
      println(s"$n: $time")
      data += ((n, time))

      if (i >= 2) draw(scaleData(data.toSeq))
    }
  }

  private def scaleData(data: Seq[(Int, Double)]): Seq[(Double, Double)] = {
    val scaledData = data
    //Uncomment to show log-log plot
//          .map{case(x, y) => (Math.log(1 + x), Math.log(y))}

    val maxX = scaledData.maxBy(_._1)._1
    val minX = scaledData.minBy(_._1)._1
    val maxY = scaledData.maxBy(_._2)._2
    val minY = scaledData.minBy(_._2)._2

    val drawScaled =
      scaledData
        .map{case(x, y) => ((x.toDouble - minX) * 0.9 / (maxX - minX), (y - minY) * 0.9 / (maxY - minY))}


    drawScaled.map{case(x, y) => (x + 0.05, y + 0.05)}
  }

  private def draw(data: Seq[(Double, Double)]) ={
    StdDraw.clear()

    StdDraw.setPenRadius()

    StdDraw.line(0d, 0.025d, 1d, 0.025d)
    StdDraw.line(0.025d, 0, 0.025d, 1d)

    for (i <- 0 until data.length - 1) {
      StdDraw.line(data(i)._1, data(i)._2, data(i+1)._1, data(i+1)._2)
    }

    StdDraw.setPenRadius(0.01d)
    for (point <- data) {
      StdDraw.point(point._1, point._2)
    }
  }
}
