package two.three

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class QuickSortWithEqualImprovementTest extends SortAlgorhitmTest {
  before {
    sorter = new QuickSortWithEqualImprovement[Int]()
  }
}
