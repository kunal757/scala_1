object LargestPalindromeProduct {
  // Function to check if a number is a palindrome
  def isPalindrome(n: Int): Boolean = {
    val s = n.toString
    s == s.reverse
  }

  def main(args: Array[String]): Unit = {
    // Generate all possible products of two 3-digit numbers using a for-yield loop
    val palindromes = for {
      i <- 100 to 999
      j <- i to 999 // j starts from i to avoid duplicate calculations
      product = i * j if isPalindrome(product)
    } yield product

    // Find the maximum palindrome
    val largestPalindrome = palindromes.max

    println(s"The largest palindrome made from the product of two 3-digit numbers is $largestPalindrome")
  }
}
