package two.one

import org.scalatest.FunSuite

class InsertionSortWithSentinelTest extends SortAlgorhitmTest {
  before {
    sorter = new InsertionSortWithoutExchanged[Int](drawer = (a: Array[Int]) => ())
  }
}
