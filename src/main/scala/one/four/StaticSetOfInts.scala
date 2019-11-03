package one.four

import java.util

import one.one.BinarySearch

class StaticSetOfInts(a: Array[Int]) {
  util.Arrays.sort(a)

  def rank(key: Int): Int = BinarySearch.rank(key, a)

  def contains(key: Int): Boolean = rank(key) != -1

  def howMuch(key: Int): Int = {
    val min = BinarySearch.rankMin(key, a)
    if (min != -1) {
      val max = BinarySearch.rankMax(key, a)
      max - min + 1
    } else 0
  }

  def howMuch2(key: Int): Int = {
    var lo = 0
    var hi = a.length - 1
    while (lo <= hi) {
      val mid = lo + (hi - lo) / 2
      if (key < a(mid)) hi = mid - 1
      else if (key > a(mid)) lo = mid + 1
      else {
        val min = doRankMin(key, a, lo, hi - 1)
        val max = doRankMax(key, a, lo + 1, hi)
        return max - min + 1
      }
    }
    0
  }


  def doRankMin(key: Int, a: Array[Int], low: Int, high: Int): Int = {
    var lo = low
    var hi = high
    var res = -1
    while (lo <= hi) {
      val mid = lo + (hi - lo) / 2
      if (key < a(mid)) hi = mid - 1
      else if (key > a(mid)) lo = mid + 1
      else {
        res = mid
        hi = mid - 1
      }
    }
    res
  }

  def doRankMax(key: Int, a: Array[Int], low: Int, high: Int): Int = {
    var lo = low
    var hi = high
    var res = -1
    while(lo <= hi) {
      val mid = lo + (hi - lo) / 2
      if(key < a(mid)) hi = mid - 1
      else if (key > a(mid)) lo = mid + 1
      else {
        res = mid
        lo = mid + 1
      }
    }
    res
  }
}
