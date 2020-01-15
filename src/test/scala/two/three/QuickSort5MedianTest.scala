package two.three

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class QuickSort5MedianTest extends SortAlgorhitmTest {
  before {
    sorter = new QuickSort5Median[Int]()
  }
}
