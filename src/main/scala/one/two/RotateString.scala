package one.two

object RotateString {
  def main(args: Array[String]): Unit = {
    val s1 = "ACTGACT"
    val s2 = "GACTACT"

    println(isRotateStrings(s1, s2))
  }

  def isRotateStrings(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length) return false
    var s = s1
    for (i <- 0 until s1.length) {
      if (s == s2) return true
      s = s.substring(1) + s(0)
    }

    false
  }
}
