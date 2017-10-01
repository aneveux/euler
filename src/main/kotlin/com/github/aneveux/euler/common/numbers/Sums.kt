package com.github.aneveux.euler.common.numbers

import com.github.aneveux.euler.common.sequences.primes
import java.math.BigInteger

/**
 * Returns the sum of the squares of all terms of the receiver range _(eg. square first, sum after)_.
 *
 * @return the sum of all the squares of the receiver
 */
fun LongRange.sumSquares() = this.map(Long::square).sum()

/**
 * Returns the square of the sum of all terms of the receiver range _(eg. sum first, square after)_.
 *
 * @return the square of the sum of all terms of the receiver
 */
fun LongRange.squareSum() = this.sum().let(Long::square)

/**
 * Returns the sum of all the receiver's digits.
 *
 * @return the sum of all the receiver's digits
 */
fun BigInteger.sumDigits() = this.digits().sum()

/**
 * Returns the sum of all the receiver's digits.
 *
 * @return the sum of all the receiver's digits
 */
fun Long.sumDigits() = this.digits().sum()

/**
 * Returns the sum of all prime numbers below the receiver number.
 *
 * @return the sum of all primes below the receiver
 */
fun Long.sumBelowPrimes() = primes.takeWhile { it < this.toBigInteger() }.sum().toLong()