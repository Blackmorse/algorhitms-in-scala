package two.three

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class QuickSortWithEqualInsertionImprovementTest extends SortAlgorhitmTest {
  before {
    sorter = new QuickSortWithEqualInsertionImprovement[Int]()
  }
}
