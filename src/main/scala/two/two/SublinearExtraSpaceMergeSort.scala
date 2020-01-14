package two.two

import edu.princeton.cs.algs4.StdRandom
import two.one.SortAlgorhitm

import scala.reflect.ClassTag

class SublinearExtraSpaceMergeSort[T: ClassTag](val blockSize: Int)(override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  override def sort(a: Array[T]): Unit = {
    if(a.length % blockSize != 0) throw new IllegalArgumentException

    val tmp = Array.fill(2 * blockSize)(null.asInstanceOf[T])

    for (i <- 0 until a.length / blockSize) {
      insertionSort(a, i * blockSize, (i + 1) * blockSize - 1)
    }

    for (_ <- 0 until a.length / blockSize) {
      sortBlocks(a)
      for (i <- 0 until a.length / blockSize - 1) mergeBlocks(a, tmp, i)
    }
  }

  private def sortBlocks(a: Array[T]): Unit = {
    val blocks = a.length / blockSize
    for (i <- 0 until blocks) {

      var minEl = a(i * blockSize)
      var minIndex = i
      for (j <- i until blocks) {
        if (a(j * blockSize) < minEl) {
          minIndex = j
          minEl = a(j * blockSize)
        }
      }
      if (i != minIndex) exchangeBlocks(a, i, minIndex)
    }
  }

  private def exchangeBlocks(a: Array[T], b1: Int, b2: Int): Unit = {
    val tmp = Array.fill(blockSize)(null.asInstanceOf[T])

    for (i <- 0 until blockSize) {
      tmp(i) = a(b1 * blockSize + i)
    }

    for(i <- 0 until blockSize) {
      a(b1 * blockSize + i) = a(b2 * blockSize + i)
    }

    for(i <- 0 until blockSize) {
      a(b2 * blockSize + i) = tmp(i)
    }
  }

  private def mergeBlocks(a: Array[T], tmp: Array[T], block: Int): Unit = {
    val lo = block * blockSize
    val hi = lo + 2 * blockSize - 1

    var leftIndex = 0
    val mid = blockSize
    var rightIndex = mid

    for(i <- 0 until 2 * blockSize) tmp(i) = a(lo + i)

    for (i <- lo to hi) {
      if(leftIndex >= mid) {a(i) = tmp(rightIndex); rightIndex += 1}
      else if (rightIndex > 2 * blockSize - 1) {a(i) = tmp(leftIndex); leftIndex +=1}
      else if(tmp(rightIndex) > tmp(leftIndex)) {a(i) = tmp(leftIndex); leftIndex +=1}
      else {a(i) = tmp(rightIndex); rightIndex += 1}
    }
  }

  private def insertionSort(array: Array[T], lo: Int, hi: Int): Unit = {
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
      while (less(el, array(j - 1))) j -= 1

      for (t <- j.until(i).reverse) {
        array(t + 1) = array(t)
      }
      array(j) = el
    }
  }
}

object SublinearExtraSpaceMergeSort {
  def main(args: Array[String]): Unit = {
    val sorter = new SublinearExtraSpaceMergeSort[Int](3)

//    val a = Array(0, 7,8, 1,5,6, 2,3,4)
    val a = Array.fill(300)(StdRandom.uniform(10000))
    sorter.sort(a)

//    a.foreach(println)
    println(sorter.isSorted(a))

    a.foreach(println)
  }
}