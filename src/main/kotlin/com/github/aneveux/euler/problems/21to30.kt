package com.github.aneveux.euler.problems

import com.github.aneveux.euler.Problem
import com.github.aneveux.euler.common.amicablePair
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