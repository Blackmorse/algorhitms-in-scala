package two.three

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class QuickSortTest extends SortAlgorhitmTest {
  before {
    sorter = new QuickSort[Int]()
  }
}
