object LargestPrimeFactor {
  def largestPrimeFactor(n: Long): Long = {
    var num = n
    var largestFactor = 1L
    var i = 2L

    while (i * i <= num) {
      if (num % i == 0) {
        largestFactor = i
        while (num % i == 0) {
          num /= i
        }
      }
      i += 1
    }

    if (num > 1) {
      largestFactor = num
    }

    largestFactor
  }

  def main(args: Array[String]): Unit = {
    val n = 600851475143L
    println(s"The largest prime factor of $n is ${largestPrimeFactor(n)}")
  }
}

