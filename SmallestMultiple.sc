object SmallestMultiple {
  // Function to calculate the Greatest Common Divisor (GCD) using the Euclidean algorithm
  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a else gcd(b, a % b)
  }

  // Function to calculate the Least Common Multiple (LCM) of two numbers
  def lcm(a: Long, b: Long): Long = {
    (a * b) / gcd(a, b)
  }

  def main(args: Array[String]): Unit = {
    // Start with the first number
    val range = 1L to 20L

    // Calculate the LCM of all numbers in the range
    val smallestMultiple = range.foldLeft(1L)(lcm)

    println(s"The smallest number that is evenly divisible by all the numbers from 1 to 20 is $smallestMultiple")
  }
}

