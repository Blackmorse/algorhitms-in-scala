package one.one

import scala.collection.mutable


object Main {
  def main(args: Array[String]): Unit = {
    val start = System.currentTimeMillis()


    val fac = fact(10)
    println(fac)
    println(log2(fac))

    val end = System.currentTimeMillis()
    val diff = end - start
    println(s"time: $diff")
  }

  def histogram(a: Array[Int], M: Int) = {
    1.to(M).map(i => a.count(_ == i)).toArray
  }

  def fib_old(f1: Int, f2: Int, n: Int): Int = {

    if (n == 0) f1
    else fib_old(f2, f1 + f2, n - 1)
  }


  def exR1(n: Int): String = {
    if (n <= 0) ""
    else exR1(n - 3) + n + exR1(n - 2) + n
  }

  def mystery(a: Int, b: Int): Int = {
    if(b ==0) 1
    else if (b % 2 == 0) mystery(a * a, b / 2)
    else mystery(a * a, b / 2) * a
  }

  def fib(n: Int): Long = {
    if (n == 0) 0
    else if (n == 1) 1
    else fib(n - 1) + fib(n - 2)
  }

  def fibArray(n: Int, fibs: mutable.ArrayBuffer[Long]): Long = {
    if (fibs(n) != -1) {
      return fibs(n)
    }

    val res = {
      if (n == 0) 0
      else if (n == 1) 1
      else fibArray(n - 1, fibs) + fibArray(n - 2, fibs)
    }
    fibs(n) = res
    res
  }

  def log2(n: Long): Int = {
    var res = 1
    var counter = 0
    while (res <= n) {
      res *= 2
      counter += 1
    }
    counter - 1
  }

  def fact(n: Int): Long = {
    if (n == 0) 1 else
    1.toLong.to(n).foldLeft(1.toLong)(_ * _)
  }
}
