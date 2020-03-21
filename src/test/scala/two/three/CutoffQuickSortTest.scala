package scala.two.three

import two.one.SortAlgorhitmTest
import two.three.CutoffQuickSort

class CutoffQuickSortTest extends SortAlgorhitmTest {
  before {
    sorter = new CutoffQuickSort[Int](5)
  }
}
