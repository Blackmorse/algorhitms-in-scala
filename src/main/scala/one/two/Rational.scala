package one.two

import java.util.Objects

import one.one.Euclid

class Rational(private val _numerator: Long, private val _denominator: Long) {
  private val r = shrink(_numerator, _denominator)
  val numerator: Long = r._1
  val denominator: Long = r._2

  private def shrink(a: Long, b: Long) = {
    val (am, bm) = if (b < 0) (-a, -b) else (a, b)
    if (b == 0) throw new IllegalArgumentException
    val divider = Euclid.doAlg(am, bm)
    (am / divider, bm / divider)
  }

  def +(other: Rational): Rational = {
    val euclid = Euclid.doAlg(denominator, other.denominator)
    val newDenominator = (denominator / euclid) * other.denominator

    val m1 = other.denominator / euclid
    val m2 = denominator / euclid

    new Rational(m1 * numerator + m2 * other.numerator, newDenominator)
  }

  def -(other: Rational): Rational = {
    this + Rational(-other.numerator, other.denominator)
  }

  def *(other: Rational): Rational = {
    Rational(numerator * other.numerator, denominator * other.denominator)
  }

  def /(other: Rational): Rational = {
    Rational(numerator * other.denominator, denominator * other.numerator)
  }

  override def toString: String = s"$numerator/$denominator"

  override def equals(obj: Any): Boolean = {
    if (!obj.isInstanceOf[Rational]) {
      false
    } else {
      val other = obj.asInstanceOf[Rational]
      numerator == other.numerator && denominator == other.denominator
    }
  }

  override def hashCode(): Int = {
    Objects.hash(numerator, denominator)
  }
}

object Rational {
  def main(args: Array[String]): Unit = {
    println(Rational(5, 6) + Rational(1, 8))
    println(Rational(23, 24) - Rational(1, 8))
    println(Rational(3, 4) * Rational(4, 3))
    println(Rational(9, 16) / Rational(3, 4))

    println(Rational(1, -5) == Rational(-1, 5))
  }

  def apply(numerator: Long, denominator: Long): Rational = {
    new Rational(numerator, denominator)
  }
}
