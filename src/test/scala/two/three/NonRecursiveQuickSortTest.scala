package two.three

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class NonRecursiveQuickSortTest extends SortAlgorhitmTest {
  before {
    sorter = new NonRecursiveQuickSort[Int]()
  }
}
