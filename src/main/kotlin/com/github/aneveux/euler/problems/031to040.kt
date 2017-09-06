package com.github.aneveux.euler.problems

import com.github.aneveux.euler.Problem
import io.vavr.Tuple3
import com.github.aneveux.euler.common.*

/**
 * Solving [https://projecteuler.net/problem=31]
 *
 * > How many different ways can £2 be made using any number of coins?
 *
 */
class Problem31 : Problem() {
    // Interesting reading: https://en.wikipedia.org/wiki/Change-making_problem
    val coins = listOf(1, 2, 5, 10, 20, 50, 100, 200)

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
    val allProducts = (1..10_000L).flatMap { n -> (1..10_000L / n).map { m -> Tuple3(n, m, n * m) } }

    override fun solve() = allProducts.filter { it.isPandigital(9) }
            .map { (n, m, product) -> product }
            .distinct()
            .sum()
            .toString()
}