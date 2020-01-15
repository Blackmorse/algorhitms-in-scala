package two.three

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class QuickSortSentinelTest extends SortAlgorhitmTest {
  before {
    sorter = new QuickSortSentinel[Int]()
  }
}
