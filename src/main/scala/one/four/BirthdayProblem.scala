package one.four

import edu.princeton.cs.algs4.StdRandom

object BirthdayProblem {
  def sameBirthday(n: Int): Int = {
    val a = Array.fill(n)(false)
    var c= 0
    do {
      val next = StdRandom.uniform(n)
      if(a(next)) return c + 1
      else {
        c += 1
        a(next) = true
      }
    } while (true)
    -1
  }

  def main(args: Array[String]): Unit = {
    val times = 100000
    val max = 10000
    val results = for ( i <- 1 to times) yield {
      sameBirthday(max)
    }
    val avg = results.sum.toDouble / times

    val approx = Math.sqrt(Math.PI * max / 2)
    println(s"n: $avg, approx: $approx")
  }
}
