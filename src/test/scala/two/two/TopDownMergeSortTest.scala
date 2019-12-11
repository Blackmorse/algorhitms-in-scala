package two.two

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class TopDownMergeSortTest extends SortAlgorhitmTest {
  before {
    sorter = new TopDownMergeSort[Int]
  }
}
