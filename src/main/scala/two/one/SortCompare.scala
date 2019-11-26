package two.one

import edu.princeton.cs.algs4.StdRandom

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

    val a = Array(1,2,3)

    val n = 1000
    val t = 300

    timeRandomInput(new InsertionSort[Double](drawer = (a: Array[Double]) => ()), n, t)

    val t1 = timeRandomInput(new ShellSort[Double](drawer = (a: Array[Double]) => ()), n, t)
    val t2 = timeRandomInput(new InsertionSort[Double](drawer = (a: Array[Double]) => ()), n, t)

    println(s"First/second: ${t1.toDouble / t2}")

  }
}
