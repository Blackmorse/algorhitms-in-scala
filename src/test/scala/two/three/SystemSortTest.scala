package two.three

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class SystemSortTest  extends SortAlgorhitmTest {
  before {
    sorter  = new SystemSort[Int]()
  }
}
