package two.two.improved

import edu.princeton.cs.algs4.StdRandom
import two.two.MergeSort

import scala.reflect.ClassTag

abstract class ImprovedMergeSort[T: ClassTag](override implicit protected val toOrdered: T => Ordered[T])
  extends MergeSort[T]  {
  override def sort(a: Array[T]): Unit = {
    val n = a.length
    var step = 1
    val copy = Array.fill[T](a.length)(null.asInstanceOf[T])

    var mainArray = true

    while (step <= n - 1) {

      var mergeBegin = 0
      while (mergeBegin < n) {
        if (mainArray) {
          merge(a, mergeBegin, mergeBegin + step - 1, mergeBegin + 2 * step - 1, copy)
        } else {
          merge(copy, mergeBegin, mergeBegin + step - 1, mergeBegin + 2 * step - 1, a)
        }

        mergeBegin += 2 * step
      }

      step *= 2
      mainArray = !mainArray
    }
    if (!mainArray) {
      for (i <- copy.indices) a(i) = copy(i)
    }

  }
}

object ImprovedMergeSort {
  def main(args: Array[String]): Unit = {

    var r = true
    var a = Array.fill(1)(0)

    var c = 0
    while(r) {

      val n = StdRandom.uniform(1000, 1500)
      println(s"N : $n")
      a = Array.fill(n)(0)
      for (i <- a.indices) a(i) = StdRandom.uniform(1000000)

      val clone = a.clone()

      val sorter = new ImprovedMergeSort[Int]() with ImprovedMerger[Int]
      sorter.sort(clone)
      r = sorter.isSorted(clone)
       c += 1
    }
    println(s"attempts : $c")
    a.foreach(println)

  }
}