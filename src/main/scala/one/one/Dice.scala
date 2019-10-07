package one.one

import edu.princeton.cs.algs4.StdRandom

object Dice {
  val sides = 6

  def theoretical(): Array[Double] = {
    val array = Array.fill(2 * sides + 1)(0d)
    for (i <- 1 to 6; j <- 1 to 6) {
      array(i + j) += 1
    }
    array.map(_ / 36.0)
  }

  def practical(n: Int): Array[Double] = {
    val array = Array.fill(2 * sides + 1)(0d)

    1 to n map (i => StdRandom.uniform(0 ,6) + StdRandom.uniform(0 ,6) + 2) foreach (i => array(i) += 1)

    array map (_ / n)
  }

  def main(args: Array[String]): Unit = {
    theoretical().zip(practical(1000000)).map(t => t._2 - t._1).foreach(println)
  }
}
