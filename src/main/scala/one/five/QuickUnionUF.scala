package one.five

class QuickUnionUF(val n: Int) extends UF {
  override def find(p: Int): Int = {
    var c = p
    while(id(c) != c) c = id(c)
    c
  }

  override def union(p: Int, q: Int): Unit = {
    val pId = find(p)
    val qId = find(q)
    if(p == q) return

    id(pId) = qId
    count -= 1
  }
}
