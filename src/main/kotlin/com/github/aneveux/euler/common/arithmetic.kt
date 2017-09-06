package com.github.aneveux.euler.common

import io.vavr.Tuple3
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

fun Long.pow(p: Long) = Math.pow(this.toDouble(), p.toDouble()).toLong()

tailrec fun BigInteger.factorial(product: BigInteger = BigInteger.ONE): BigInteger =
        if (this == BigInteger.ZERO) product
        else (this - BigInteger.ONE).factorial(product.multiply(this))

fun sumDigits(n: BigInteger) = n.toString().toCharArray().map { it.toIntValue() }.sum()

fun Long.properDivisors() = (1..(this / 2)).filter { this isMultipleOf it }
fun Long.isPerfect() = this.properDivisors().sum() == this
fun Long.isDeficient() = this.properDivisors().sum() < this
fun Long.isAbundant() = this.properDivisors().sum() > this

fun Long.amicablePair(): Long? {
    val sum = this.properDivisors().sum()
    if (sum != this && sum.properDivisors().sum() == this)
        return sum
    else return null
}

fun Long.isPandigital(indice: Int = this.toString().length): Boolean {
    fun isPandigital(number: String, digits: List<Int>): Boolean = when {
        number.isEmpty() -> digits.isEmpty()
        else -> {
            val first = number.first().toIntValue()
            digits.contains(first) && isPandigital(number.substring(1), digits - first)
        }
    }
    return with(this.toString()) {
        isPandigital(this, (1..length).toList()) && length == indice
    }
}

fun Tuple3<Long, Long, Long>.isPandigital() = this.let { (a, b, c) ->
    "$a$b$c".toLong().isPandigital()
}

fun Tuple3<Long, Long, Long>.isPandigital(indice: Int) = this.isPandigital() && this.let { (a, b, c) ->
    "$a$b$c".length == indice
}