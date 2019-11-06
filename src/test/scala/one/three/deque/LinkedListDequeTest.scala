package one.three.deque

import org.scalatest.FunSuite

class LinkedListDequeTest extends DequeTest {

  before{
    deque = new LinkedListDeque[Int]
  }
}
