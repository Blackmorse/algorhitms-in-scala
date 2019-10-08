package one.two

import edu.princeton.cs.algs4.StdDraw

class VisualCounter(val n: Int, val max: Int) {
  private var value = 0
  private var actions = 0

  private val xScale = 1.toDouble / n
  private val yScale = 1.toDouble / max

  def increment(): Unit = {
    if (actions < n) {

      if(value < max) {
        value += 1
      }

      StdDraw.filledRectangle((actions + 0.5) * xScale, value * yScale / 2, xScale / 2, value * yScale / 2)

      actions += 1
    }
  }

  def decrement(): Unit = {
    if (actions < n) {

      value -= 1

      StdDraw.filledRectangle((actions + 0.5) * xScale, value * yScale / 2, xScale / 2, value * yScale / 2)
      actions += 1
    }
  }

  def getValue = value
}

object VisualCounter {
  def main(args: Array[String]): Unit = {
    val counter = new VisualCounter(10, 5)
    counter.increment()
    counter.increment()
    counter.increment()
    counter.increment()
    counter.increment()
    counter.increment()
    counter.increment()
    counter.increment()
    counter.decrement()
    counter.decrement()
    counter.decrement()
    counter.decrement()
    counter.decrement()
  }
}
