package one.five

trait UF {
  val n: Int
  val id: Array[Int] = (0 until n).toArray
  var count = n

  def find(p: Int): Int

  def union(p: Int, q: Int): Unit

  def connected(p: Int, q: Int): Boolean = find(p) == find(q)
}

