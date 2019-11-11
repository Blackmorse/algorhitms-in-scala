package one.five

class QuickFindUF(val n: Int) extends UF {
  override def find(p: Int): Int = id(p)

  override def union(p: Int, q: Int): Unit = {
    val pId = find(p)
    val qId = find(q)
    if(pId == qId) return

    for (i <- id.indices) {
      if(id(i) == pId) id(i) = qId
    }
    count -= 1
  }
}
