package com.github.aneveux.euler.problems

import com.github.aneveux.euler.Problem
import com.github.aneveux.euler.common.amicablePair
import com.github.aneveux.euler.common.isAbundant
import java.io.File
import java.lang.Character.isLetter

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

/**
 * Solving [https://projecteuler.net/problem=22]
 *
 * > What is the total of all the name scores in the file?
 *
 */
class Problem22 : Problem() {
    /**
     * Returns the score of a String, which is the sum of all the letters indexes.
     */
    fun String.score() = this.toList().filter(::isLetter).map(Char::toInt).map { it - 64 }.sum()

    val names = File("src/main/resources/022.txt").readText().split(",")

    fun namesScores(names: List<String>) = names.sorted()
            .mapIndexed { index, name ->
                name.score() * (index + 1)
            }.sum()

    override fun solve() = namesScores(names).toString()
}

/**
 * Solving [https://projecteuler.net/problem=23]
 *
 * > Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 *
 */
class Problem23 : Problem() {
    fun LongRange.abundantNumbers() = this.filter { it.isAbundant() }

    val limit = 28123L
    val abundants = (1L..limit).abundantNumbers()
    val abundantsSums = abundants.flatMap { n ->
        abundants.takeWhile { it <= limit - n }
                .map { it + n }
    }
    val nonAbundantsSum = (1L..limit).minus(abundantsSums)

    override fun solve() = nonAbundantsSum.sum().toString()
}
