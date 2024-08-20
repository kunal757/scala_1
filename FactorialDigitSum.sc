object FactorialDigitSum {
  // Function to calculate the factorial of a number using BigInt
  def factorial(n: Int): BigInt = {
    (BigInt(1) to BigInt(n)).product
  }

  def main(args: Array[String]): Unit = {
    // Calculate 100!
    val factorial100 = factorial(100)

    // Convert the factorial result to a string, then to a sequence of digits
    val digitSum = factorial100.toString.map(_.asDigit).sum

    println(s"The sum of the digits in the number 100! is $digitSum")
  }
}