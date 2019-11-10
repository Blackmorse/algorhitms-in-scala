package one.four

import edu.princeton.cs.algs4.{ResizingArrayStack, Stack}

object StackTest {
  def runStack(a: Array[Int]) = {
    val stack = new Stack[Int]()
    a foreach stack.push
    while(!stack.isEmpty) stack.pop()
  }

  def runStackArray(a: Array[Int]) = {
    val stack = new ResizingArrayStack[Int]()
    a foreach stack.push
    while(!stack.isEmpty) stack.pop()
  }

  def main(args: Array[String]): Unit = {
    DoublingTest.doTest(200000, 9, runStack)
    DoublingTest.doTest(200000, 9, runStackArray)
  }
}
