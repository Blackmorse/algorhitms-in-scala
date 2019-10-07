package one.one

import edu.princeton.cs.algs4.{StdIn, StdRandom}

object Shuffle {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val m = StdIn.readInt()

    val matrix = new Matrix(m, m)

    for (i <- 1 to n) {
      val arr = 0.until(m).toArray
      StdRandom.shuffle(arr)

      for (j <- arr.indices) {
        matrix.arr(arr(j))(j) += 1d
      }
    }

    matrix.print()
  }
}
