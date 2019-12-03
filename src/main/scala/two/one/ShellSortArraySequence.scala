package two.one

import edu.princeton.cs.algs4.StdRandom

import scala.collection.mutable


class ShellSortArraySequence[T](override val drawer: ADrawer[T] = (a: Array[T]) => (),
                                seq: Seq[Int])(implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] with Drawable[T] {
  var compares = 0
  var isExchanged = false

  override def sort(a: Array[T]): Unit = {
    compares = 0
    isExchanged = false
    val n = a.length

    val sequence = seq.reverse

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


    var h = 1
    var buf = mutable.Buffer[Int]()
    while(h > 0)  {
      h = 3 * h + 1
      buf += h
    }

    val sorter = new ShellSortArraySequence[Double](drawer = (a: Array[Double]) => (), seq = buf.toSeq)

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
