package one.five

import one.five.drawtree.DrawTree

class QuickUnionUF(val n: Int) extends UF {
  override def find(p: Int): Int = {
    var c = p
    while(id(c) != c) c = id(c)
    c
  }

  override def union(p: Int, q: Int): Unit = {
    val pId = find(p)
    val qId = find(q)
    if(pId == qId) return

    var c = p

    while(id(c) != c) {
      val cc = id(c)
      id(c) = qId
      c = cc
    }
    id(c) = qId

    c = q

    do {
      val cc = id(c)
      id(c) = qId
      c = cc
    } while(id(c) != c)
    count -= 1
  }
}

object QuickUnionUF {
  def main(args: Array[String]): Unit = {
    val uf = new QuickUnionUF(8)

    uf.union(0, 1)
    uf.union(1, 2)
    uf.union(3, 2)
    uf.union(3, 4)
    uf.union(4, 5)

    DrawTree.draw(uf.id)
  }
}
