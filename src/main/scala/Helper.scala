package help;

import java.io.File

import edu.princeton.cs.algs4.StdRandom

import scala.io.Source

object Helper {
  def randomArray(length: Int, low: Int, high: Int) = {
    (1 to length map (_ => StdRandom.uniform(low, high))).toArray
  }

  def readIntsFromFile(path: String): Array[Int] = {
    (for (line <- Source.fromFile(new File(path)).getLines()) yield {
      line.trim.toInt
    }).toArray
  }
}
