package two.one

import org.scalatest.FunSuite

class InsertionSortWithSentinelWithoutExchangesTest extends SortAlgorhitmTest {
  before {
    sorter = new InsertionSortWithSentinelWithoutExchanges[Int]()
  }
}
