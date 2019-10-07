package one.one

import edu.princeton.cs.algs4.StdRandom

class Matrix(val n: Int, val m: Int) {
  var arr = Array.ofDim[Double](n, m)

  def this(other: Array[Array[Double]]) {
    this(other.size, other(0).size)
    //TODO clone
    arr = other
  }

  def fillRandom(): Unit = {
    def gen: () => Double = () => StdRandom.uniform(-10.0, 10.0)
    for (i <- 0 until n; j <- 0 until m) {
      arr(i)(j) = gen()
    }
  }

  def *(matrix: Matrix): Matrix = {
    if (m != matrix.n) throw new IllegalArgumentException
    val res = new Matrix(n, matrix.m)
    for (i <-0 until n; j <- 0 until matrix.m) {
      res.arr(i)(j) =  matrix.arr.map(_(i)).zip(arr(j)).map({case(a, b) => a * b}).sum
    }

    res
  }

  def transpose(): Unit = {
    if (n != m) throw new IllegalArgumentException
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
    val m = new Matrix(1,3)
    m.fillRandom()
    m.print()
    println()
    val m2 = new Matrix(3,1)
    m2.fillRandom()
    m2.print()
    println()
    (m * m2).print

  }

  def scalar(vec1: Array[Double], vec2: Array[Double]) = {
    vec1.zip(vec2).map{case (a,b) => a * b}.sum
  }

  implicit def toMatrix(arr: Array[Double]): Matrix = {
    new Matrix(Array(arr))
  }
}
