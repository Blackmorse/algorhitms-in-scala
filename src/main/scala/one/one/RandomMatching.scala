package one.one

import edu.princeton.cs.algs4.{StdIn, StdRandom}

object RandomMatching {
  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    val ress = Array.fill(4)(0)
    for (i <- 1 to t) {
      val r1 = experiment(1000)
      val r2 = experiment(10000)
      val r3 = experiment(100000)
      val r4 = experiment(1000000)

      ress(0) += r1
      ress(1) += r2
      ress(2) += r3
      ress(3) += r4
    }
    ress.map(r => r.toDouble / t).foreach(println)

  }

  def experiment(n: Int) = {
    val a1 = Array.fill(n)(StdRandom.uniform(1000000, 10000000))
    val a2 = Array.fill(n)(StdRandom.uniform(1000000, 10000000))

    a1.foldLeft(0){case(sum, el) => if (BinarySearch.rank(el, a2) == -1) sum else sum + 1}
  }
}
