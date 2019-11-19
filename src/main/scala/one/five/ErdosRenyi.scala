package one.five

import edu.princeton.cs.algs4.StdRandom

object ErdosRenyi {
  def number(n: Int): Int = {
    val uf = new WeightenedQuickUnionWithPathCompressionUF(n)

    var i = 0
    while(uf.count != 1) {
      val r1 = StdRandom.uniform(n)
      val r2 = StdRandom.uniform(n)

      uf.union(r1, r2)

      i += 1
    }
    i
  }

  def main(args: Array[String]): Unit = {
    var avgPrev = 0.toDouble
    var m = 10
    for (i <- 1 to 15) {
      val a = 1 to 500 map (_ => number(m))
      val avg = a.sum.toDouble / a.size

      val diff = if (avgPrev == 0.toDouble) Double.NaN else avg / avgPrev
      println(s"m: $m, avg: $avg, diff: $diff")
      avgPrev = avg
      m *= 2
    }
  }
}
