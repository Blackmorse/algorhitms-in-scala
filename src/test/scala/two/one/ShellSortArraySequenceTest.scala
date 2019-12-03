package two.one

import org.scalatest.FunSuite

class ShellSortArraySequenceTest extends SortAlgorhitmTest {
  before {
    sorter = new ShellSortArraySequence[Int](drawer = (a: Array[Int]) => (), Seq(1, 4, 13, 40))
  }
}
