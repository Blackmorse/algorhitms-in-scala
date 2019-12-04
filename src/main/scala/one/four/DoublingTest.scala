package one.four

import edu.princeton.cs.algs4.{StdDraw, StdRandom, Stopwatch}

import scala.collection.mutable

object DoublingTest {
  val MAXIMUM_INTEGER = 1000000

  private def timeTrial[T](n: Int, f: Array[Int] => T, testNumber: Int): Double = {
    val a = Array.fill(n)(0).map(_ => StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER))
    val timer = new Stopwatch()
    1 to testNumber foreach (_ => f(a))
    timer.elapsedTime()
  }

  def doTest[T](startN: Int, iterations: Int, f: Array[Int] => T, logPlot: Boolean = false, testNumber: Int = 1): Unit = {
    var n = startN
    val data = mutable.Buffer[(Int, Double)]()
    var previousTime: Option[Double] = None

    for (i <- 1 to iterations) {
      val time = timeTrial(n, f, testNumber) / testNumber
      val diff = previousTime.map(pt => time / pt).getOrElse(Double.NaN)

      println(s"$n: $time. x$diff")
      data += ((n, time))

      if (i >= 2) drawScaled(scaleData(data.toSeq, logPlot))
      n += n
      previousTime = Some(time)
    }
  }

  def main(args: Array[String]): Unit = {
    doTest(250, 9, ThreeSum.count, true)
    println("---end----")
  }

  def draw(data: Seq[(Int, Double)], log: Boolean = false): Unit =  {
    drawScaled(scaleData(data, log))
  }

  private def scaleData(data: Seq[(Int, Double)], logPlot: Boolean = false): Seq[(Double, Double)] = {
    val scaledData = if (logPlot) data.map{case(x, y) => (Math.log(1 + x), Math.log(y))}
                  else data.map{case(x, y) => (x.toDouble, y)}

    val maxX = scaledData.maxBy(_._1)._1
    val minX = scaledData.minBy(_._1)._1
    val maxY = scaledData.maxBy(_._2)._2
    val minY = scaledData.minBy(_._2)._2

    val drawScaled =
      scaledData
        .map{case(x, y) => ((x.toDouble - minX) * 0.9 / (maxX - minX), (y - minY) * 0.9 / (maxY - minY))}


    drawScaled.map{case(x, y) => (x + 0.05, y + 0.05)}
  }

  private def drawScaled(data: Seq[(Double, Double)]) ={
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
