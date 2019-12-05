package two.one.tools

import edu.princeton.cs.algs4.StdRandom
import two.one.{InsertionSort, SelectionSort, ShellSort, SortAlgorhitm}

import scala.collection.mutable

object Distribution {
  def distribution(algorithm: SortAlgorhitm[Double], n: Int, t: Int = 1) = {

    val buffer = mutable.Buffer[(Int, Double)]()
    var  k = 1
    while (true) {

      val a = Array.fill(n)(StdRandom.uniform())

      val time1 = System.currentTimeMillis()
      for (i <- 1 to t) {
        algorithm.sort(a)
      }
      val time = System.currentTimeMillis() - time1

      if (k > 1) {
        if (k > 100) buffer.remove(0)
        buffer += ((k, time.toDouble))

        one.four.DoublingTest.draw(buffer.toSeq)
      }
      k += 1
    }
  }

  def main(args: Array[String]): Unit = {
    distribution(new ShellSort[Double], 200000, 10)
  }
}
