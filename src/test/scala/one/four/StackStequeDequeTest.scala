package one.four

import one.three.deque.DequeTest
import org.scalatest.FunSuite

class StackStequeDequeTest extends DequeTest {
  before {
    deque = new StackStequeDeque[Int]
  }
}
