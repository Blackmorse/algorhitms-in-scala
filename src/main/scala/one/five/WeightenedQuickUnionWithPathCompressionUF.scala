package one.five

import edu.princeton.cs.algs4.StdDraw
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
      while(c != id(c)) {
        val cc = id(c)
        id(c) = rootP
        c = cc
      }
      id(c) = rootP


      c = p
      do {
        val cc = id(c)
        id(c) = rootP
        c = cc
      } while(c != id(c))

      sizes(rootP) += sizes(rootQ)
    } else {
      var c = p
      while(c != id(c)) {
        val cc = id(c)
        id(c) = rootQ
        c = cc
      }
      id(c) = rootQ

      c = q
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
    val uf = new WeightenedQuickUnionWithPathCompressionUF(16)
    //first 3-height
    uf.union(1, 0 )
    uf.union(2, 3 )
    uf.union(3, 0 )

    uf.union(5, 4 )
    uf.union(6, 7 )
    uf.union(7, 4 )

    uf.union(0, 4 )

    //second 3-height
    uf.union(9, 8 )
    uf.union(10, 11 )
    uf.union(11, 8 )

    uf.union(13, 12 )
    uf.union(14, 15 )
    uf.union(15, 12 )

    uf.union(8, 12 )

    //4-height
    uf.union(4, 12 )
    DrawTree.draw(uf.id)
  }
}
