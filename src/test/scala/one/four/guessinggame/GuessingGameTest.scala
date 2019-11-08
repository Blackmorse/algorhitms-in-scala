package one.four.guessinggame

import org.scalatest.FunSuite
import one.four.guessinggame.GuessingClient

class GuessingGameTest extends FunSuite {
  test("test game") {
    for (i <- 1 to 200; j <- 0 until i) {
      val client = new GuessingClient(i, Some(j))

      assert(GuessingGame.guess(client) == j)
    }
  }
}
