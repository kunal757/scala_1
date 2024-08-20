object LargestPrimeFactor {
  def largestPrimeFactor(n: Long): Long = {
    @scala.annotation.tailrec
    def factorize(current: Long, divisor: Long): Long = {
      if (divisor * divisor > current) current // No further divisors, current is the largest prime factor
      else if (current % divisor == 0) factorize(current / divisor, divisor) // Divide out the divisor
      else factorize(current, divisor + 1) // Try the next possible divisor
    }

    factorize(n, 2)
  }

  def main(args: Array[String]): Unit = {
    val n = 600851475143L
    println(s"The largest prime factor of $n is ${largestPrimeFactor(n)}")
  }
}
