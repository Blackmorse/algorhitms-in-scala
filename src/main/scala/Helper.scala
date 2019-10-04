package help;

import edu.princeton.cs.algs4.StdRandom

object Helper {
  def randomArray(length: Int, low: Int, high: Int) = {
    (1 to length map (_ => StdRandom.uniform(low, high))).toArray
  }
}
