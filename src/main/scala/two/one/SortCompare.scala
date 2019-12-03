package two.one

import edu.princeton.cs.algs4.StdRandom

import scala.collection.mutable

object SortCompare {
  def time(alg: SortAlgorhitm[Double], a: Array[Double]): Long = {
    val t1 = System.currentTimeMillis()
    alg.sort(a)
    System.currentTimeMillis() - t1
  }

  def timeRandomInput(alg: SortAlgorhitm[Double], n: Int, t: Int): Long = {
    (1 to t map (_ => {
      val a = (1 to n map (_ => StdRandom.uniform())).toArray
      time(alg, a)
    })).sum
  }

  def main(args: Array[String]): Unit = {
    val n = 100000
    val t = 50

    var h = 1
    var buf = mutable.Buffer[Int]()
    while(h > 0)  {
      buf += h
      h = 3 * h + 1
    }

    val seq1 = buf.toSeq
    val seq2 = Seq(1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609)

    val t1 = timeRandomInput(new ShellSortArraySequence[Double](drawer = (a: Array[Double]) => (), seq1), n, t)
    val t2 = timeRandomInput(new ShellSortArraySequence[Double](drawer = (a: Array[Double]) => (), seq2), n, t)

    println(s"First/second: ${t1.toDouble / t2}")
  }

  def findDegreesSequence(): Unit = {
    def degrees(d: Int, N: Int) = LazyList.unfold(1)(s => Some((s * d, s * d))).takeWhile(_ < N)

    val n = 100000
    val t = 5
    //    timeRandomInput(new InsertionSort[Double](drawer = (a: Array[Double]) => ()), n, t)

    for (d <- (2 to 100).reverse) {

      val t1 = timeRandomInput(new ShellSortArraySequence[Double](drawer = (a: Array[Double]) => (), degrees(d, n)), n, t)
      println(s"d = $d. Time: $t1")
    }
  }
}
