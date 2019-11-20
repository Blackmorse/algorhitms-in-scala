package one.five

import edu.princeton.cs.algs4.StdRandom

object ErdosRenyi {
  def number(n: Int, ufF: Int => UF = new WeightenedQuickUnionWithPathCompressionUF(_)): Int = {
    val uf = ufF(n)
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

    val t = 10
    var avgPrev = 0.toDouble
    var m = 1000
    var prevTime = 0d
    for (i <- 1 to 15) {
      val time1 = System.currentTimeMillis()

      val a = 1 to t map (_ => number(m, new QuickFindUF(_)))

      val time2 = System.currentTimeMillis()

      val time = (time2 - time1) / t
      val timeRatio = if (prevTime == 0) Double.NaN else time.toDouble / prevTime

      val avg = a.sum.toDouble / a.size

      val diff = if (avgPrev == 0.toDouble) Double.NaN else avg / avgPrev
      println(s"m: $m, avg: $avg, diff: $diff. Time: $time, ratioTime: $timeRatio")
      prevTime = time
      avgPrev = avg
      m *= 2
    }
  }
}
