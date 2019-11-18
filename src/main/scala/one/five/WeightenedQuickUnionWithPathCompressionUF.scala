package one.five

import one.five.drawtree.DrawTree

class WeightenedQuickUnionWithPathCompressionUF(val n: Int) extends UF {
  val sizes = Array.fill(n)(1)

  override def find(p: Int): Int = {
    var c = p
    while(id(c) != c) c = id(c)
    c
  }

  override def union(p: Int, q: Int): Unit =  {
    val rootP = find(p)
    val rootQ = find(q)

    if (rootP == rootQ) return

    if (sizes(rootP) > sizes(rootQ)) {
      var c = q
      do {
        val cc = id(c)
        id(c) = rootP
        c = cc
      } while(c != id(c))


      sizes(rootP) += sizes(rootQ)
    } else {
      var c = p
      do {
        val cc = id(c)
        id(c) = rootQ
        c = cc
      } while(c != id(c))
      sizes(rootQ) += sizes(rootP)
    }
    count -=1
  }
}

object WeightenedQuickUnionWithPathCompressionUF {
  def main(args: Array[String]): Unit = {
    val uf = new WeightenedQuickUnionWithPathCompressionUF(14)

    uf.union(0, 2 )
    uf.union(1, 3)
    uf.union(2,4)
    uf.union(4,6)

    DrawTree.draw(uf.id)
  }
}
