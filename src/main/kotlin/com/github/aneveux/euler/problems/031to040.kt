package com.github.aneveux.euler.problems

import com.github.aneveux.euler.Problem

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