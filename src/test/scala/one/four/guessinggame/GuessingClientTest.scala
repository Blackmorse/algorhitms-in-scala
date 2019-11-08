package one.four.guessinggame

import edu.princeton.cs.algs4.StdRandom
import org.scalatest.FunSuite

class GuessingClientTest extends FunSuite {
  test("test guessing client") {
    StdRandom.setSeed(1L)

    val client = new GuessingClient(20)

    assert(client.guess(10) == None)
    assert(client.guess(15) == Some(Cold))
    assert(client.guess(14) == Some(Hot))
    assert(client.guess(3) == Some(Hot))
    assert(client.guess(7) == Some(Hot))
    assert(client.guess(8) == Some(Cold))
    assert(client.guess(2) == Some(Hot))
  }
}
