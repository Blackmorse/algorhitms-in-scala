package help;

import java.io.File

import edu.princeton.cs.algs4.StdRandom
import two.one.SortAlgorhitm

import scala.io.Source

object Helper {

  def randomArray(length: Int, low: Int, high: Int) = {
    (1 to length map (_ => StdRandom.uniform(low, high))).toArray
  }

  def readIntsFromFile(path: String): Array[Int] = {
    (for (line <- Source.fromFile(new File(path)).getLines()) yield {
      line.trim.toInt
    }).toArray
  }

  def cartesianProduct[T <: AnyRef](seq: Seq[T]): Seq[(T, T)] = {
    seq.flatMap(s1 => seq.flatMap(s2 => if (s1.eq(s2)) Seq() else Seq((s1,s2))))
  }

  def distinctCartesian[T <: AnyRef](seq: Seq[T]): Seq[(T, T)] = {
    for (i <- 0 until seq.size; j <- i + 1 until seq.size) yield (seq(i), seq(j))
  }

  def shuffle[T](a: Array[T]) = {
    if (a == null) throw new IllegalArgumentException("argument array is null")
    val n = a.length
    var i = 0
    while (i < n) {
      val r = i + StdRandom.uniform(n - i)
      // between i and n-1
      val temp = a(i)
      a(i) = a(r)
      a(r) = temp

      i += 1
    }
  }

  def insertionSortSlice[T](array: Array[T], lo: Int, hi: Int)(implicit toOrdered: T => Ordered[T]): Unit = {
    var minIndex = lo
    var minValue = array(lo)
    for (i <- lo to hi) {
      if (array(i) < minValue) {
        minValue = array(i)
        minIndex = i
      }
    }
    SortAlgorhitm.exch(array, lo, minIndex)

    for (i <- lo + 1 to hi) {
      var j = i
      val el = array(i)
      while (el < array(j - 1)) j -= 1

      for (t <- j.until(i).reverse) {
        array(t + 1) = array(t)
      }
      array(j) = el
    }
  }
}
