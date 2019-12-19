package two.two.kmerge

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class KWayMergeSortTest extends SortAlgorhitmTest {
  before {
    sorter = new KWayMergeSort[Int](3)
  }
}
