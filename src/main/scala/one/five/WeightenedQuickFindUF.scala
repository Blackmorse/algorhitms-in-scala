package one.five

class WeightenedQuickFindUF(val n: Int) extends UF {
  val sizes = Array.fill(n)(1)

  override def find(p: Int): Int = id(p)

  override def union(p: Int, q: Int): Unit = {
    val pComponent = find(p)
    val qComponent = find(q)
    if(pComponent == qComponent) return

//    val component = if (sizes(pComponent) > sizes(qComponent)) pComponent else qComponent

//    for (i <- id.indices) {
//      if (id(i) == pComponent || id(i) == qComponent) id(i) = component
//    }
//    sizes(pComponent) += sizes(qComponent)

    if(sizes(pComponent) > sizes(qComponent)) {
      for (i <- id.indices) {
        if(id(i) == qComponent) id(i) = pComponent
      }
      sizes(pComponent) += sizes(qComponent)
    } else {
      for (i <- id.indices) {
        if (id(i) == pComponent) id(i) = qComponent
      }
      sizes(qComponent) += sizes(pComponent)
    }
  }
}
