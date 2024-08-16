import java.math.BigInteger

object FactorialDigitSum {
  // Function to calculate the factorial of a number using BigInteger
  def factorial(n: Int): BigInteger = {
    (BigInteger.ONE to BigInteger.valueOf(n)).product
  }

  // Extension method to easily compute the product of a range of BigIntegers
  implicit class BigIntegerRange(val range: Range.BigInt) {
    def product: BigInteger = {
      range.foldLeft(BigInteger.ONE) { (acc, x) => acc.multiply(x) }
    }
  }

  def main(args: Array[String]): Unit = {
    // Calculate 100!
    val factorial100 = factorial(100)

    // Convert the factorial result to a string, then to a sequence of digits
    val digitSum = factorial100.toString.map(_.asDigit).sum

    println(s"The sum of the digits in the number 100! is $digitSum")
  }
}

