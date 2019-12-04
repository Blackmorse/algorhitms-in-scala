package two.one

import java.util.concurrent.TimeUnit

import edu.princeton.cs.algs4.{StdDraw, StdRandom, Transaction}

abstract class ADrawer[T] {
  def draw(a: Array[T])
}

class Drawer extends ADrawer[Double] {
  override def draw(a: Array[Double]): Unit = {
    TimeUnit.MILLISECONDS.sleep(300)
    StdDraw.clear()

    val leftSpan = 0.1
    val rightSpan = 0.1

    val upSpan = 0.2
    val downSpan = 0.3

    val max = a.max
    val min = a.min

    val yScale = 1/ (max - min - 0.2)

    val intervals = a.length
    val intervalWidth = (1 -leftSpan - rightSpan) / intervals

    a.zipWithIndex.map { case (value, index) => (intervalWidth * (index + 0.5), value / yScale, value) }


    val tuples = a.zipWithIndex.map{case (value, index) => (intervalWidth * index, intervalWidth * (index + 1), 0d, value / yScale)}

    val coords = tuples.map{case (x1,x2, y1,y2) => ((x2 + x1)/2, (y2 + y1) / 2, intervalWidth / 2, (y2 + y1) / 2)}

    coords.foreach(c => {
      StdDraw.filledRectangle(0.1 + c._1, 0.1 + c._2, c._3, c._4)
      StdDraw.setPenColor(StdDraw.GREEN)
      StdDraw.rectangle(0.1 + c._1, 0.1 + c._2, c._3, c._4)
      StdDraw.setPenColor(StdDraw.BLACK)
    })
//    tuples
//      .foreach{case(x, y, value) => StdDraw.rectangle(x, y, intervalWidth / 2, value / (2 * yScale))}


  }
}

object Drawer {
  def main(args: Array[String]): Unit = {
  }
}

