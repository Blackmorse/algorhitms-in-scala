package two.three

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class QuickSort3MedianTest extends SortAlgorhitmTest {
  before{
    sorter = new QuickSort3Median[Int]()
  }
}
