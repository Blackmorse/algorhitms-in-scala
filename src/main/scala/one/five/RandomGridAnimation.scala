package one.five

import java.util.concurrent.TimeUnit

import edu.princeton.cs.algs4.{StdDraw, StdIn}
import one.five.drawtree.DrawTree

object RandomGridAnimation {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val edges = RandomGridGenerator.generate(n)

    val uf = new QuickUnionUF(n)

    for ((a, b) <- edges) {
      StdDraw.clear()
      uf.union(a, b)
      DrawTree.draw(uf.id)
      TimeUnit.MILLISECONDS.sleep(500)
    }
  }
}
