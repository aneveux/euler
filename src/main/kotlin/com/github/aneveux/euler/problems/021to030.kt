package com.github.aneveux.euler.problems

import com.github.aneveux.euler.Problem
import com.github.aneveux.euler.common.numbers.*
import com.github.aneveux.euler.common.sequences.big_fibonacci
import com.github.aneveux.euler.common.sequences.replicate
import io.vavr.collection.Stream
import io.vavr.control.Option
import java.io.File
import java.lang.Character.isLetter
import java.math.BigInteger
import io.vavr.collection.List as VList

/**
 * Solving [https://projecteuler.net/problem=21]
 *
 * > Evaluate the sum of all the amicable numbers under 10000.
 *
 */
class Problem21 : Problem() {
    private fun amicableNumbersUntil(limit: Long) = (1..limit).filter { it.amicablePair().isDefined }

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

    private val names = File("src/main/resources/022.txt").readText().split(",")

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

    private val limit = 28123L
    private val abundants = (1L..limit).abundantNumbers()
    private val abundantsSums = abundants.flatMap { n ->
        abundants.takeWhile { it <= limit - n }
                .map { it + n }
    }
    private val nonAbundantsSum = (1L..limit).minus(abundantsSums)

    override fun solve() = nonAbundantsSum.sum().toString()
}

/**
 * Solving [https://projecteuler.net/problem=24]
 *
 * > What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 */
class Problem24 : Problem() {
    fun computePermutations(vararg elements: Char): VList<String> = VList.ofAll(*elements).permutations()
            .map { it.joinToString(separator = "", prefix = "", postfix = "") }

    override fun solve(): String = computePermutations(*"0123456789".toCharArray())
            .elementAtOrElse(1_000_000 - 1) { "Permutation Not Found" }
}

/**
 * Solving [https://projecteuler.net/problem=25]
 *
 * > What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 *
 */
class Problem25 : Problem() {
    override fun solve() = (big_fibonacci.indexOfFirst { it.toString().length == 1_000 } + 1).toString()
}

/**
 * Solving [https://projecteuler.net/problem=26]
 *
 * > Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 *
 */
class Problem26 : Problem() {
    // See http://mathworld.wolfram.com/DecimalExpansion.html
    // And http://mathworld.wolfram.com/MultiplicativeOrder.html
    fun multiplicativeOrder(i: Long) = (1L until i).find { j ->
        10L.toBigInteger().modPow(j.toBigInteger(), i.toBigInteger()) <= BigInteger.ONE
    } ?: 0

    override fun solve() = (1L..999).mapIndexed { index, i -> index + 1 to multiplicativeOrder(i) }
            .maxBy { (_, v) -> v }?.first.toString()
}

/**
 * Solving [https://projecteuler.net/problem=27]
 *
 * > Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.
 *
 */
class Problem27 : Problem() {
    private fun quadratic(n: Long, a: Long, b: Long) = n.square() + a * n + b
    private val limits: Stream<Long> = Stream.range(-1_000L, 1_000)

    //     Limit set following this:
    //     n = 80 (because of incredible formula from the problem)
    //     a = 1_000 (limit)
    //     b = 1_000 (limit)
    //     in the incredible formula from the problem: n²+an+b = 87_400
    private val nLimit: Stream<Long> = Stream.range(0L, 87_400)

    private val combinations: Stream<Pair<Long, Long>> = limits.flatMap { a -> limits.map { b -> a to b } }

    private val maxPrimePair: Option<Pair<Long, Long>> = combinations.maxBy { (a, b) ->
        nLimit.takeWhile { n -> quadratic(n, a, b).isPrime() }.count()
    }

    override fun solve() = maxPrimePair.get().let { (a, b) -> a * b }.toString()
}

/**
 * Solving [https://projecteuler.net/problem=28]
 *
 * > What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 *
 */
class Problem28 : Problem() {
    fun spiralSum(squareSize: Int): Number = Stream.rangeBy(2, squareSize, 2)
            .flatMap { it.replicate(4) }
            .scanLeft(1) { buffer, value -> buffer + value }
            .sum()

    override fun solve() = spiralSum(1_001).toString()
}

/**
 * Solving [https://projecteuler.net/problem=29]
 *
 * > How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
 *
 */
class Problem29 : Problem() {
    fun LongRange.distinctPowers() = this.flatMap { a -> this.map { b -> a to b.toInt() } }
            .map { (a, b) -> a.toBigInteger().pow(b) }.toSet()

    override fun solve() = (2L..100).distinctPowers().count().toString()
}

/**
 * Solving [https://projecteuler.net/problem=30]
 *
 * > Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 *
 */
class Problem30 : Problem() {
    private val powersOf5 = listOf(0L, 1, 32, 243, 1_024, 3_125, 7_776, 16_807, 32_768, 59_049)

    fun Long.sumDigitsPowersOf5() = this.digits().map { powersOf5[it] }.sum()

    override fun solve() = Stream.range(2, 9L.pow(5) * 5)
            .filter { it == it.sumDigitsPowersOf5() }.sum().toString()
}