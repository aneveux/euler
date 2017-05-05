package com.github.aneveux.euler.problems

import com.github.aneveux.euler.Problem
import com.github.aneveux.euler.common.*
import javaslang.Tuple3
import javaslang.collection.Stream

/**
 * Solving [https://projecteuler.net/problem=1]
 *
 * > Find the sum of all the multiples of 3 or 5 below 1000.
 *
 */
class Problem1 : Problem() {
    fun sumMultiples(limit: Int) = Stream.range(1, limit)
            .filter { (it isMultipleOf 3) or (it isMultipleOf 5) }
            .sum()

    override fun solve() = sumMultiples(1_000).toString()
}

/**
 * Solving [https://projecteuler.net/problem=2]
 *
 * > By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 *
 */
class Problem2 : Problem() {
    override fun solve() = fibonacci.takeWhile { it < 4_000_000 }
            .filter(Int::isEven)
            .sum().toString()
}

/**
 * Solving [https://projecteuler.net/problem=3]
 *
 * > What is the largest prime factor of the number 600851475143?
 *
 */
class Problem3 : Problem() {
    override fun solve() = 600851475143L.primeFactors().max().toString()
}

/**
 * Solving [https://projecteuler.net/problem=4]
 *
 * > Find the largest palindrome made from the product of two 3-digit numbers.
 *
 */
class Problem4 : Problem() {
    val threeDigitNumbers = (100L..999L)

    fun largestPalindromeFromProducts(range: LongRange) = range.products(range).filter(Number::isPalindrome).max()

    override fun solve() = largestPalindromeFromProducts(threeDigitNumbers).toString()
}

/**
 * Solving [https://projecteuler.net/problem=5]
 *
 * > What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 */
class Problem5 : Problem() {
    override fun solve() = Stream.from(19L, 19L).first { it.isEvenlyDivisibleBy((1..20)) }.toString()
}

/**
 * Solving [https://projecteuler.net/problem=6]
 *
 * > Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 */
class Problem6 : Problem() {
    fun squareSumMinusSumSquares(range: IntRange) = range.squareSum() - range.sumSquares()

    override fun solve() = squareSumMinusSumSquares((1..100)).toString()
}

/**
 * Solving [https://projecteuler.net/problem=7]
 *
 * > What is the 10 001st prime number?
 *
 */
class Problem7 : Problem() {
    override fun solve() = primes.get(10_000).toString()
}

/**
 * Solving [https://projecteuler.net/problem=8]
 *
 * > Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
 *
 */
class Problem8 : Problem() {

    val grid = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"

    fun maxProductOfAdjacentDigits(digits: Long) = Stream.ofAll(grid.toList()).map(Char::toIntValue).sliding(digits).map(
            Stream<Int>::product).max().get()

    override fun solve() = maxProductOfAdjacentDigits(13L).toString()
}

/**
 * Solving [https://projecteuler.net/problem=9]
 *
 * > There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
 *
 */
class Problem9 : Problem() {
    override fun solve() = Stream.range(1, 333).flatMap { a ->
        Stream.range(a + 1, 500).flatMap { b ->
            Stream.range(b + 1, 998).map { c ->
                Tuple3(a, b, c)
            }
        }
    }.filter { (a, b, c) ->
        a + b + c == 1_000 && Tuple3(a, b, c).isPythagoreanTriplet()
    }.map { (a, b, c) -> a * b * c }.first().toString()
}