object LargestPalindromeProduct {
  // Function to check if a number is a palindrome
  def isPalindrome(n: Int): Boolean = {
    val s = n.toString
    s == s.reverse
  }

  def main(args: Array[String]): Unit = {
    var largestPalindrome = 0

    // Iterate over all possible products of two 3-digit numbers
    for (i <- 999 to 100 by -1) {
      for (j <- i to 100 by -1) { // j starts from i to avoid duplicate calculations
        val product = i * j
        if (isPalindrome(product) && product > largestPalindrome) {
          largestPalindrome = product
        }
      }
    }

    println(s"The largest palindrome made from the product of two 3-digit numbers is $largestPalindrome")
  }
}

