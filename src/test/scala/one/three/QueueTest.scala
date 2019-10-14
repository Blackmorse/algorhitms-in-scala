package one.three

import org.scalatest.FunSuite

class QueueTest extends FunSuite {
  test("test from queue to stack and back") {
    val q = new Queue[String]
    q.enqueue("1").enqueue("2").enqueue("3")

    val stack = new Stack[String]
    while (!q.isEmpty) stack.push(q.dequeue)
    while (!stack.isEmpty) q.enqueue(stack.pop)

    assert("3" == q.dequeue())
    assert("2" == q.dequeue())
    assert("1" == q.dequeue())
  }
}
