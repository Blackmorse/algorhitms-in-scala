package one.one

object Euclid {

  def main(args: Array[String]): Unit = {
    println(rec(1234567, 1111111))
  }

  /**
    * p must be greater than q
    * @param p
    * @param q
    * @return
    */
  def rec(p: Int, q: Int): Int = {
    println(s"$p, $q")
    val o = p % q
    if (o == 0) q
    else rec(q, o)
  }
}
