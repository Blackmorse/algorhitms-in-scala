package two.one

import edu.princeton.cs.algs4.StdRandom

import scala.collection.mutable

class ShellSortArraySequence[T](override val drawer: ADrawer[T] = (a: Array[T]) => ())(implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  var compares = 0
  var isExchanged = false

  override def sort(a: Array[T]): Unit = {
    compares = 0
    isExchanged = false
    val n = a.length

    val arrayBuffer= mutable.Buffer[Int]()

    var t = 1
    while(t < n / 3) {
      arrayBuffer += t
      t = 3 * t + 1
    }

    val sequence = arrayBuffer.toArray.reverse

    for (h <- sequence) {
      drawer.draw(a)
      for (i <- h until n) {
        var j = i
        while (j >= h && less(a(j), a(j -h ))) {
          exch(a, j, j-h)
          j -= h
        }
      }
    }
  }

  override protected def exch(a: Array[T], i: Int, j: Int): Unit = {
    isExchanged = true
    super.exch(a, i, j)
  }

  override protected def less(a: T, b: T): Boolean = {
    compares += 1
    a.compareTo(b) < 0
  }
}

object ShellSortArraySequence {
  def main(args: Array[String]): Unit = {

    val sorter = new ShellSortArraySequence[Double](drawer = (a: Array[Double]) => ())



    var n = 10

    var oldRel = Double.NaN


    for (i <- 1 to 7) {
      val a = (1 to n map (_ => StdRandom.uniform())).toArray
      sorter.sort(a)

      val comp = sorter.compares.toDouble / n

      val div = if (oldRel == Double.NaN) Double.NaN else comp/oldRel

      println(s"n: $n, compares: ${sorter.compares}, rel: $comp, rate: $div")

      n *= 10
      oldRel = comp
    }

  }
}
