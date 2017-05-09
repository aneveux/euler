package com.github.aneveux.euler.common

import javaslang.Tuple3
import java.math.BigInteger

infix fun Number.isMultipleOf(n: Number) = this.toLong() % n.toLong() == 0L
infix fun BigInteger.isMultipleOf(i: BigInteger) = this.mod(i).signum() == 0

fun Number.isEven() = this isMultipleOf 2
fun Number.isOdd() = !this.isEven()

fun Number.isPalindrome() = with(this.toString()) {
    reversed().contentEquals(this)
}

fun Number.square() = with(this.toLong()) {
    this * this
}

fun Number.sqrtRange() = Math.sqrt(this.toDouble()).toLong()

fun LongRange.products(with: LongRange) = this.flatMap { a -> with.map { b -> a * b } }

fun Number.isEvenlyDivisibleBy(range: IntRange) = range.all { this isMultipleOf it }

fun IntRange.sumSquares() = this.map(Number::square).sum()
fun IntRange.squareSum() = this.sum().let(Number::square)

fun Tuple3<Int, Int, Int>.isPythagoreanTriplet() = this.let { (a, b, c) ->
    a.square() + b.square() == c.square()
}

fun Number.numberOfDivisors() = with(this.primeFactors()) {
    distinct().fold(1) { n, prime ->
        n * (this.count { it == prime } + 1)
    }
}