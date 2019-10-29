package one.three

import one.three.StackPermutation.alg
import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer

class StackPermutationTest extends FunSuite {
  test("test 1") {
    val arr = Array(4,6,8,7,5,3,2,9,1,0)
    val res = alg(arr)
    assert(actionsToNumbers(res) sameElements  arr)
  }

  test("test 2") {
    val arr = Array(2, 5, 6, 7, 4, 8, 9, 3, 1, 0)
    val res = alg(arr)
    assert(actionsToNumbers(res) sameElements arr)
  }

  test("test fail") {
    val arr = Array(0, 4, 6, 5, 3, 8, 1, 7, 2, 9)
    assertThrows[Exception] {
      alg(arr)
    }
  }

  def actionsToNumbers(queue: Queue[String]): Array[Int] = {
    val stack = new Stack[Int]()
    val result = ArrayBuffer[Int]()

    for (action <- queue) {
      if (action.startsWith("push")) {
        val n = action.split(" ")(1).toInt
        stack.push(n)
      } else {
        result += stack.pop
      }
    }
    result.toArray
  }
}
