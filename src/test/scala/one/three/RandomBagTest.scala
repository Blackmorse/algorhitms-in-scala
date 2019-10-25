package one.three

import edu.princeton.cs.algs4.StdRandom
import org.scalatest.FunSuite

class RandomBagTest extends FunSuite {
  test("Test random iterator") {
    StdRandom.setSeed(1L)

    val bag = new RandomBag[Int]
    bag.add(5)
    bag.add(10)
    bag.add(15)
    bag.add(20)
    bag.add(25)

    val iterator = bag.iterator

    assert(iterator.next() == 5)
    assert(iterator.next() == 10)
    assert(iterator.next() == 20)
    assert(iterator.next() == 15)
    assert(iterator.next() == 25)
    assert(!iterator.hasNext)
  }

}
