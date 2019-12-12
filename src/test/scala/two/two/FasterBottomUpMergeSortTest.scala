package two.two

import two.one.SortAlgorhitmTest

class FasterBottomUpMergeSortTest extends SortAlgorhitmTest {
  before {
    sorter = new BottomUpMergeSort[Int]() with  FasterCopyMerger[Int]
  }
}
