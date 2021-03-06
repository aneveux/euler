package com.github.aneveux.euler.problems

import com.github.aneveux.euler.Problem
import com.github.aneveux.euler.common.helpers.component1
import com.github.aneveux.euler.common.helpers.component2
import com.github.aneveux.euler.common.helpers.component3
import com.github.aneveux.euler.common.numbers.*
import com.github.aneveux.euler.common.sequences.primes
import io.vavr.Tuple3
import io.vavr.collection.Stream

/**
 * Solving [https://projecteuler.net/problem=31]
 *
 * > How many different ways can £2 be made using any number of coins?
 *
 */
class Problem31 : Problem() {
    // Interesting reading: https://en.wikipedia.org/wiki/Change-making_problem
    private val coins = listOf(1, 2, 5, 10, 20, 50, 100, 200)

    fun combinations(target: Int, maxCoinIndex: Int = coins.size): Int = when {
        target == 0 -> 1
        target < 0 -> 0
        maxCoinIndex <= 0 && target >= 1 -> 0
        else -> (combinations(target, maxCoinIndex - 1)
                 + combinations(target - coins[maxCoinIndex - 1], maxCoinIndex))
    }

    override fun solve() = combinations(200).toString()
}

/**
 * Solving [https://projecteuler.net/problem=32]
 *
 * > Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 *
 */
class Problem32 : Problem() {
    // If n is 4 numbers, result will be 4 numbers as well. So no need to go beyond 4 numbers for n.
    // m doesn't need to go all the way to 4 numbers either, and we can simply go up to 4 numbers / n,
    // so it brings a fair balance with the result of the product, which will increase accordingly.
    private val allProducts = (1..10_000L).flatMap { n -> (1..10_000L / n).map { m -> Tuple3(n, m, n * m) } }

    override fun solve() = allProducts.filter { it.isPandigital(9) }
            .map { (_, _, product) -> product }
            .distinct()
            .sum()
            .toString()
}

/**
 * Solving [https://projecteuler.net/problem=33]
 *
 * > If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 *
 */
class Problem33 : Problem() {
    private val fractions = (1..10).flatMap { i ->
        (1..10).flatMap { denominator ->
            (1 until denominator).filter { numerator ->
                denominator * (10 * numerator + i) == numerator * (10 * i + denominator)
            }.map { numerator -> numerator to denominator }
        }
    }

    private val product = fractions.reduce { (a, b), (c, d) -> (a * c) to (b * d) }

    override fun solve() = product.let { (_, denominator) ->
        denominator / product.greatestCommonFactor()
    }.toString()
}

/**
 * Solving [https://projecteuler.net/problem=34]
 *
 * > Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 */
class Problem34 : Problem() {
    private val factorials = listOf<Long>(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)

    fun Long.hasFactorialDigits() = this == digits().map { factorials[it] }.sum()

    override fun solve() = (3L..999_999).filter { it.hasFactorialDigits() }.sum().toString()
}

/**
 * Solving [https://projecteuler.net/problem=35]
 *
 * > How many circular primes are there below one million?
 *
 */
class Problem35 : Problem() {
    override fun solve() = Stream.range(2L, 1_000_000).filter { it.isCircularPrime() }
            .count().toString()
}

/**
 * Solving [https://projecteuler.net/problem=36]
 *
 * > Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 *
 */
class Problem36 : Problem() {
    override fun solve() = Stream.range(1L, 1_000_000).filter { it.isDoubleBasePalindromic() }
            .sum().toString()
}

/**
 * Solving [https://projecteuler.net/problem=37]
 *
 * > Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 *
 */
class Problem37 : Problem() {
    override fun solve() = primes.map { it.toLong() }.takeWhile { it < 1_000_000L }
            .filter { it.isTruncatablePrime() }
            .take(11).sum().toString()
}