package one.one

object Euclid {

  def main(args: Array[String]): Unit = {
    println(rec(1234567, 1111111))
  }

  def doAlg(a: Long, b: Long): Long = {
    if (a == 0 || b == 0) 1 else {
      if (b > a) rec(b, a)
      else rec(a, b)
    }
  }

  /**
    * p must be greater than q
    * @param p
    * @param q
    * @return
    */
  private def rec(p: Long, q: Long): Long = {
//    println(s"$p, $q")
    val o = p % q
    if (o == 0) q
    else rec(q, o)
  }
}
