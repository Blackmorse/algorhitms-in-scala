package two.two

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class NaturalMergeSortTest extends SortAlgorhitmTest {
  before {
    sorter = new NaturalMergeSort[Int]() with CopyMerger[Int]
  }
}
