package one.four

object LocalMinimumAndMaximum {
  def arrayMinimum(a: Array[Int]): Int = {
    var lo = 0
    var hi = a.length - 1

    while(lo < hi) {
      val mid = lo + (hi - lo) / 2
      if (mid == 0) {
        if (a(mid+1) > a(mid)) return 0
        else lo = 1
      } else if(mid == a.length - 1) {
        if (a(mid - 1) > a(mid)) return a.length - 1
        else hi = mid - 1
      } else if(a(mid - 1) > a(mid) && a(mid + 1) > a(mid)) {
        return mid
      } else if(a(mid - 1) < a(mid)) {
        hi = mid - 1
      } else if(a(mid + 1) < a(mid)) {
        lo = mid + 1
      }
    }
    lo
  }

  def arrayMaximum(a: Array[Int]): Int = {
    var lo = 0
    var hi = a.length - 1

    while(lo < hi) {
      val mid = lo + (hi - lo) / 2
      if (mid == 0) {
        if(a(mid + 1) < a(mid)) return 0
        else lo = 1
      } else if (mid == a.length - 1) {
        if (a(mid - 1) < a(mid)) return a.length - 1
        else hi = mid - 1
      } else if (a(mid) > a(mid - 1) && a(mid) > a(mid + 1)) {
        return mid
      } else if(a(mid) < a(mid - 1)) {
        hi = mid - 1
      } else if (a(mid) < a(mid + 1)) {
        lo = mid + 1
      }
    }
    hi
  }
}
