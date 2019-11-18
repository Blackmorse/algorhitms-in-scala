package one.five

class WeightedQuickUnionUF(val n: Int) extends UF {
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
      id(rootQ) = rootP
      sizes(rootP) += sizes(rootQ)
    } else {
      id(rootP) = rootQ
      sizes(rootQ) += sizes(rootP)
    }
    count -=1
  }
}
