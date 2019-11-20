package one.five

object CompareQuickFindAndQuickUnion {
  def main(args: Array[String]): Unit = {
    val t = 10
    var n = 200

    var totalRatio = 0d


    for (i <- 1 to t) {
      val connections = RandomGridGenerator.generate(n)
      val qfUf = new WeightenedQuickUnionWithPathCompressionUF(n)
      val time1 = System.currentTimeMillis()
      number(connections, qfUf)
      val time2 = System.currentTimeMillis()

      val quUf = new QuickFindUF(n)
      val time3 = System.currentTimeMillis()
      number(connections, quUf)
      val time4 = System.currentTimeMillis()

      val ratio = (time2 - time1).toDouble / (time4 - time3)
      println(s"N: $n, ratio: $ratio")
      totalRatio += ratio

      n *= 2
    }

    println("_____________")
    println(s"Total ratio: ${totalRatio / t}")
  }

  def number(connections: Iterable[(Int, Int)], uf: UF) = {
    val iterator = connections.iterator
    while(uf.count != 1) {
      val (a,b) = iterator.next()
      uf.union(a, b)
    }
  }
}
