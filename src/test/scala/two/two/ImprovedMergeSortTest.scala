package two.two

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest
import two.two.improved.{ImprovedMergeSort, ImprovedMerger}

class ImprovedMergeSortTest extends SortAlgorhitmTest {
  before {
    sorter = new ImprovedMergeSort[Int] with ImprovedMerger[Int]
  }
}
