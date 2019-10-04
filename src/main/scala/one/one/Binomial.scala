package one.one

import scala.collection.mutable

object Binomial {
  var c: Long = 0L

  def main(args: Array[String]): Unit = {
    val map = new mutable.HashMap[(Int,Int), Double]()

//    println(s"res: ${recCache(100, 5, 0.5, map)}")
    println(s"res: ${rec(100, 5, 0.5)}")
  }

  def rec(n: Int, k: Int, p: Double): Double = {
    c = c + 1
    if (n ==0 && k== 0) 1.0
    else if(n < 0 || k < 0) 0.0
    else (1.0 -p) * rec(n - 1, k, p) + p * rec(n-1, k-1, p)
  }


  def recCache(n: Int, k: Int, p: Double, map: mutable.Map[(Int,Int), Double]): Double = {
    println((n, k))

    val update: (Int, Int) => Double = (a, b) =>  {
      if (map.contains((a, b))) {
        map((a, b))
      } else {
        val cache = recCache(a, b, p, map)
        map += ((a, b) -> cache)
        cache
      }
    }

//    c = c + 1
    if (n ==0 && k== 0) 1.0
    else if(n < 0 || k < 0) 0.0
    else {

      val cache1 = update(n - 1, k)
      val cache2 = update(n - 1, k - 1)

      (1.0 -p) * cache1 + p * cache2
    }
  }


}
