package two.one


class SelectionSortTest extends SortAlgorhitmTest {
  before {
    sorter = new SelectionSort[Int](drawer = (a: Array[Int]) => ())
  }
}
