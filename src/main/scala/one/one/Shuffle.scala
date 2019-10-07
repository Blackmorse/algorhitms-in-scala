package one.one

import edu.princeton.cs.algs4.{StdIn, StdRandom}

object Shuffle {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val m = StdIn.readInt()

    val matrix = shuffleMatrix(n, m, StdRandom.shuffle)
    matrix.print()

    println("Wrong: ")

    val wrongMatrix = shuffleMatrix(n, m, wrongShuffle)
    wrongMatrix.print()
  }

  def shuffleMatrix(n: Int, m: Int,shuffle: Array[Int] => Unit): Matrix = {
    val matrix = new Matrix(m, m)

    for (_ <- 1 to n) {
      val arr = 0.until(m).toArray
      shuffle(arr)

      for (j <- arr.indices) {
        matrix.arr(arr(j))(j) += 1d
      }
    }
    matrix
  }

  def wrongShuffle(a: Array[Int]) = {
    val n = a.length
    for (i <- 0 until n) {
      val r =  StdRandom.uniform(n)
      val temp = a(i)
      a(i) = a(r)
      a(r) = temp
    }
  }
}
