package com.github.aneveux.euler.common

import java.math.BigInteger

infix fun Number.isMultipleOf(n: Number) = this.toLong() % n.toLong() == 0L
infix fun BigInteger.isMultipleOf(i: BigInteger) = this.mod(i).signum() == 0

fun Number.isEven() = this isMultipleOf 2
fun Number.isOdd() = !this.isEven()

fun Number.isPalindrome() = this.toString().reversed().contentEquals(this.toString())

fun LongRange.products(with: LongRange) = this.flatMap { a -> with.map { b -> a * b } }

fun Number.isEvenlyDivisibleBy(range: IntRange) = range.all { this.toLong() % it.toLong() == 0L }

fun IntRange.sumSquares() = this.map { it * it }.sum()
fun IntRange.squareSum() = this.sum().let { it * it }