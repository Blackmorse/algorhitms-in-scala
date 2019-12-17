package two.two

import edu.princeton.cs.algs4.StdRandom
import one.three.LinkedList
import org.scalatest.FunSuite

class LinkedListNaturalMergeSortTest extends FunSuite {
  test("test") {
    val sorter = new LinkedListNaturalMergeSort[Int]()
    for (_ <- 1 to 1000) {

      val list = new LinkedList[Int]()

      for(_ <- 1 to StdRandom.uniform(1, 3000)) {
        list.add(StdRandom.uniform(-1000, 1000))
      }
      sorter.sort(list)

      var el = list.first
      var next = list.first.next

      while(next != null) {
        assert(next.value >= el.value)
        el = el.next
        next = next.next
      }

    }
  }
}
