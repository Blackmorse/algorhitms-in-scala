package one.four.guessinggame

import edu.princeton.cs.algs4.StdRandom

sealed abstract class Guess {}

object Hot extends Guess
object Cold extends Guess
object Guessed extends Guess

class GuessingClient(val n: Int, myNumber: Option[Int] = None) {
  val number = myNumber.getOrElse(StdRandom.uniform(n))
  var previousGuess = -1

  def guess(i: Int): Option[Guess] = {
    if(i < 0 || i >= n) throw new IllegalArgumentException
    if (previousGuess == -1 && i != number) {previousGuess = i; return None}

    val previousDifference = Math.abs(previousGuess - number)
    val currentDifference = Math.abs(i - number)
    previousGuess = i
    if (currentDifference == 0) return Some(Guessed)
    if (currentDifference <= previousDifference) Some(Hot) else Some(Cold)
  }
}

object GuessingGame {

  sealed abstract class Case

  object OneTwo extends Case
  object Third extends Case
  object Fourth extends Case

  def guess(client: GuessingClient): Int = {
    val n = client.n

    var lo = 0
    var hi = n - 1

    var cas: Case = OneTwo

    while(lo <= hi) {
      cas match {
        case OneTwo => {
          val r1 = client.guess(lo)
          if (r1.contains(Guessed)) return lo
          val r = client.guess(hi)

          r match {
            case Some(Guessed) => return hi
            case Some(Cold) => {
              cas = OneTwo

              hi = if ((hi -lo) % 2 == 0) lo + (hi - lo) /2 - 1 else lo + (hi - lo) / 2
              lo += 1
            }
            case Some(Hot) => {
              cas = Third
              lo = if ((hi - lo) % 2 == 0) lo + (hi - lo) / 2 else lo + (hi - lo) / 2 + 1
              hi -= 1
            }
          }
        }
        case Third => {
          val r = client.guess(lo)

          r match {
            case Some(Guessed) => return lo
            case Some(Cold) => {
              cas = OneTwo
              lo = if ((hi - lo) % 2 == 0) lo + (hi - lo) / 2 + 1 else lo + (hi + 1 - lo) / 2 + 1
            }
            case Some(Hot) => {
              cas = Fourth
              hi = if((hi - lo) % 2 == 0) lo + (hi - lo) / 2 else lo + (hi - lo) / 2 + 1
              lo += 1
            }
          }
        }
        case Fourth => {
          val r = client.guess(hi)

          r match {
            case Some(Guessed) => return hi
            case Some(Cold) => {
              cas = OneTwo
              hi = lo + (hi - lo) / 2 - 1
            }
            case Some(Hot) => {
              cas = Third
              lo = lo + (hi - lo) / 2
              hi -= 1
            }
          }
        }
      }
    }

    -1
  }

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 1000; j <- 0 until i) {
      val client = new GuessingClient(i, Some(j))

      if (guess(client) != j) throw  new Exception(s"$i, $j")
    }

  }
}
