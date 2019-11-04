package one.four

import java.util

object DistancePairs {
  def closest(arr: Array[Double]): (Double, Double) = {
    val a = arr.clone()
    util.Arrays.sort(a)

    var dist = Math.abs(a(1) - a(0))
    var first: Double = a(0)
    var second: Double = a(1)

    for(i <- 1 until a.length) {
      val newDist = Math.abs(a(i) - a(i - 1))
      if (newDist < dist) {
        first = a(i - 1)
        second = a(i)
        dist = newDist
      }
    }
    (first, second)
  }
}
