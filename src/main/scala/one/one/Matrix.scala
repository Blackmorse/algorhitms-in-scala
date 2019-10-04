package one.one

import edu.princeton.cs.algs4.StdRandom

class Matrix(val n: Int, val m: Int) {
  var arr = Array.ofDim[Double](m, n)

  def this(other: Array[Array[Double]]) {
    this(other.size, other(0).size)
    //TODO clone
    arr = other
  }

  def fillRandom(): Unit = {
    def gen: () => Double = () => StdRandom.uniform(-10.0, 10.0)
    for (i <- 0 until n; j <- 0 until m) {
      arr(j)(i) = gen()
    }
  }

  def *(vec: Array[Double]) = {
    if(n != vec.size) throw new IllegalArgumentException
    val res = Array.fill(m)(0.0)
    for (i <- arr.indices) {
      val a = arr(i)
      res(i) = a.zip(vec).map{case (a,b) => a * b}.sum
    }
    Matrix.toMatrix(res)
  }

  def *(matrix: Matrix): Matrix = {
    if (m != matrix.n) throw new IllegalArgumentException
    val res = new Matrix(m, matrix.n)

    for (i <- 0 until m; j <- 0 until matrix.n) {
      val vec = matrix.arr.map(_(j))
      res.arr(i)(j) = arr(i).zip(vec).map{case (a,b) => a * b}.sum
    }

    res
  }

  def transpose(): Unit = {
    for (i <- 0 until n; j <- 0 until m; if i < j) {
      val t = arr(j)(i)
      arr(j)(i) = arr(i)(j)
      arr(i)(j) = t
    }
  }

  def print(): Unit = {
    arr.map(_.mkString(", ")).foreach(println)
  }
}

object Matrix {
  def main(args: Array[String]): Unit = {
    val m = new Matrix(3,2)
    m.fillRandom()
    m.print()
    println()
    val n = new Matrix(2,4)
    n.fillRandom()
    n.print()
    println()
    (m * n).print()
  }

  def scalar(vec1: Array[Double], vec2: Array[Double]) = {
    vec1.zip(vec2).map{case (a,b) => a * b}.sum
  }

  implicit def toMatrix(arr: Array[Double]): Matrix = {
    new Matrix(Array(arr))
  }
}
