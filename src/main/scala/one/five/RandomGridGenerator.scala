package one.five

import edu.princeton.cs.algs4.StdIn
import one.three.RandomBag

object RandomGridGenerator {
  def generate(n: Int): Iterable[(Int, Int)] = {
    val bag = new RandomBag[(Int, Int)]
    for (i <- 0 until n; j <- 0 until n) bag.add((i, j))
    bag
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    generate(n).foreach(println)
  }
}
