package one.three

import org.scalatest.FunSuite

class CopyStackTest extends FunSuite {
  test("test") {
    val stack = new Stack[String].push("1").push("2").push("3").push("4")
    val copyStack = CopyStack.copyStack(stack)

    while (!stack.isEmpty) {
      assert(stack.pop == copyStack.pop)
    }

    assert(copyStack.isEmpty)
  }
}
