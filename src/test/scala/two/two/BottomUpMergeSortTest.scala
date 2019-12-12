package two.two

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class BottomUpMergeSortTest extends SortAlgorhitmTest {
  before {
    sorter = new BottomUpMergeSort[Int] with CopyMerger[Int]
  }
}
