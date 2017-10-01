package com.github.aneveux.euler.common.numbers

import java.math.BigInteger


/**
 * Checks if this number is a multiple of the provided number _(eg. this % other == 0)_.
 *
 * _Reference: [http://mathworld.wolfram.com/Multiple.html]_
 *
 * @return true if the receiver is a multiple of the provided number
 */
infix fun Long.isMultipleOf(other: Long) = this % other == 0L

/**
 * Checks if this number is a multiple of the provided number _(eg. this % other == 0)_.
 *
 * _Reference: [http://mathworld.wolfram.com/Multiple.html]_
 *
 * @return true if the receiver is a multiple of the provided number
 */
infix fun BigInteger.isMultipleOf(other: BigInteger) = this.mod(other).signum() == 0

/**
 * Checks if a number is evenly divisible by all the elements of a range _(eg. is multiple of all the elements)_.
 *
 * @return true if the receiver is evenly divisible by all the elements of the range
 */
fun Long.isEvenlyDivisibleBy(range: LongRange) = range.all { this isMultipleOf it }

/**
 * Returns a List containing the products of all combinations between the receiver range and the provided range.
 *
 * @return a List of all the products from all the elements of the ranges
 */
fun LongRange.products(others: LongRange) = this.flatMap { a -> others.map { b -> a * b } }

/**
 * Returns a List containing all prime factors of the receiver numbers _(eg. factorization of receiver into its consituent primes)_.
 *
 * _Reference: [http://mathworld.wolfram.com/PrimeFactor.html]_
 *
 * @return a List containing all prime factors of the receiver number
 */
fun Long.primeFactors(): List<Long> = if (isPrime()) listOf(this) else {
    val nextPrimeFactor = (2..this.sqrt().floor()).find { this isMultipleOf it && it.isPrime() }
    if (nextPrimeFactor == null) emptyList()
    else listOf(nextPrimeFactor) + (this / nextPrimeFactor).primeFactors()
}

/**
 * Returns the number of divisors of the receiver number.
 *
 * _Reference: [http://mathworld.wolfram.com/Divisor.html]_
 *
 * @return the number of divisors of the receiver number
 */
fun Long.numberOfDivisors() = with(this.primeFactors()) {
    distinct().fold(1) { n, prime ->
        n * (this.count { it == prime } + 1)
    }
}

/**
 * Returns a List containing all the proper divisors of the receiver _(eg. divisors of receiver but itself)_.
 *
 * _Reference: [http://mathworld.wolfram.com/ProperDivisor.html]_
 *
 * @return all the receiver's proper divisors
 */
fun Long.properDivisors() = (1..(this / 2)).filter { this isMultipleOf it }

/**
 * Returns the factorial of the receiver _(eg. receiver!)_.
 *
 * _Reference: [http://mathworld.wolfram.com/Factorial.html]_
 *
 * @return the factorial of the receiver
 */
tailrec fun BigInteger.factorial(product: BigInteger = BigInteger.ONE): BigInteger =
        if (this == BigInteger.ZERO) product
        else (this - BigInteger.ONE).factorial(product.multiply(this))