package one.five

import one.five.drawtree.DrawTree

class WeightenedQuickUnionByHeightUF(val n: Int) extends UF {
  val heights = Array.fill(n)(0)

  override def find(p: Int): Int = {
    var c = p
    while(id(c) != c) c = id(c)
    c
  }

  override def union(p: Int, q: Int): Unit = {
    val rootP = find(p)
    val rootQ = find(q)

    if (rootP == rootQ) return

    val pHeight = heights(rootP)
    val qHeight = heights(rootQ)
    if (pHeight > qHeight) {
      id(rootQ) = rootP
    } else {
      id(rootP) = rootQ
      if (pHeight == qHeight) heights(rootQ) += 1
    }

    count -= 1
  }
}

object WeightenedQuickUnionByHeightUF {
  def main(args: Array[String]): Unit = {
    val uf = new WeightenedQuickUnionByHeightUF(10)

    uf.union(0, 1)
    uf.union(2, 3)
    uf.union(0, 2)



    DrawTree.draw(uf.id)
  }
}
