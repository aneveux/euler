package com.github.aneveux.euler.problems

import com.github.aneveux.euler.Problem
import com.github.aneveux.euler.common.amicablePair

/**
 * Solving [https://projecteuler.net/problem=21]
 *
 * > Evaluate the sum of all the amicable numbers under 10000.
 *
 */
class Problem21 : Problem() {
    fun amicableNumbersUntil(limit: Long) = (1..limit).filter { it.amicablePair() != null }

    override fun solve() = amicableNumbersUntil(10_000).sum().toString()
}