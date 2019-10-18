package one.two

import edu.princeton.cs.algs4.Transaction

object TransactionClient {
  def apply(input: String): Transaction = {
    val split = input.split(" ")
    val who = split(0)
    val when = DateClient(split(1))
    val amount = split(2).toDouble
    new Transaction(who, when, amount)
  }
}
