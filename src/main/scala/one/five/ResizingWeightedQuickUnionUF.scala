package one.five

import scala.collection.mutable

class ResizingWeightedQuickUnionUF  {
  val array = mutable.Buffer[Int]()
  val sizes = mutable.Buffer.fill(array.size)(1)
  var count = array.size

  def n: Int = array.size

  def newSite: Int = {
    val size  = n
    array += n
    sizes += 1
    count += 1
    size
  }

  def find(p: Int): Int = {
    var c = p
    while(array(c) != c) c = array(c)
    c
  }

  def union(p: Int, q: Int): Unit = {
    val rootP = find(p)
    val rootQ = find(q)

    if (rootP == rootQ) return

    if (sizes(rootP) > sizes(rootQ)) {
      array(rootQ) = rootP
      sizes(rootP) += sizes(rootQ)
    } else {
      array(rootP) = rootQ
      sizes(rootQ) += sizes(rootP)
    }
    count -=1
  }
}
