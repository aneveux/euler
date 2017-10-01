package com.github.aneveux.euler.common.numbers

import com.github.aneveux.euler.common.helpers.component1
import com.github.aneveux.euler.common.helpers.component2
import com.github.aneveux.euler.common.helpers.component3
import io.vavr.Tuple3
import io.vavr.control.Option
import io.vavr.control.Option.none
import io.vavr.control.Option.some

/**
 * Checks if a number is palindromic _(eg. same when written forwards or backwards)_.
 *
 * _Reference: [http://mathworld.wolfram.com/PalindromicNumber.html]_
 *
 * @return true if the receiver is a palindromic number
 */
fun Long.isPalindromic() = with(this.toString()) { reversed().contentEquals(this) }

/**
 * Checks if the receiver number is a prime number _(eg. only divisors are 1 and itself)_.
 *
 * _Reference: [http://mathworld.wolfram.com/PrimeNumber.html]_
 *
 * @return true if the receiver number is a prime
 */
fun Long.isPrime() = this > 1 && (2..this.sqrt().floor()).all { !(this isMultipleOf it) }

/**
 * Checks if the 3 receiver numbers are forming a Pythagorean triple _(eg. a² + b² = c²)_.
 *
 * _Reference: [http://mathworld.wolfram.com/PythagoreanTriple.html]_
 *
 * @return true if the 3 receiver numbers are forming a Pythagorean triple
 */
fun Tuple3<Long, Long, Long>.isPythagoreanTriple() = this.let { (a, b, c) ->
    a.square() + b.square() == c.square()
}

/**
 * Checks if the receiver number is perfect _(eg. the sum of its proper divisors equals itself)_.
 *
 * _Reference: [http://mathworld.wolfram.com/PerfectNumber.html]_
 *
 * @return true if the receiver is a perfect number
 */
fun Long.isPerfect() = this.properDivisors().sum() == this

/**
 * Checks if the receiver number is deficient _(eg. the sum of its proper divisors is inferior to itself)_.
 *
 * _Reference: [http://mathworld.wolfram.com/DeficientNumber.html]_
 *
 * @return true if the receiver is a deficient number
 */
fun Long.isDeficient() = this.properDivisors().sum() < this

/**
 * Checks if the receiver number is an abundant number _(eg. the sum of its proper divisors is superior to itself)_.
 *
 * _Reference: [http://mathworld.wolfram.com/AbundantNumber.html]_
 *
 * @return true if the receiver is an abundant number
 */
fun Long.isAbundant() = this.properDivisors().sum() > this

/**
 * Checks if a receiver number has an amicable pair _(eg. numbers for which the sum of divisors equals the other number)_.
 *
 * _Reference: [http://mathworld.wolfram.com/AmicablePair.html]_
 *
 * @return true if the receiver has an amicable pair
 */
fun Long.hasAmicablePair() = this.properDivisors().sum()
        .let { it != this && it.properDivisors().sum() == this }

/**
 * Checks if the receiver number has an amicable pair and returns it if found.
 *
 * @see [hasAmicablePair]
 *
 * @return the amicable pair of the receiver if found
 */
fun Long.amicablePair(): Option<Long> = this.properDivisors().sum()
        .let { if (it != this && it.properDivisors().sum() == this) some(it) else none() }

/**
 * Checks if the receiver is a pandigital number _(eg. contains one occurence of each number up to the specified indice)_.
 *
 * _Reference: [http://mathworld.wolfram.com/PandigitalNumber.html]_
 *
 * @return true if the receiver is a pandigital number
 */
fun Long.isPandigital(indice: Int = this.digits().size) = with(this.digits()) {
    containsAll((1..indice).toList()) && size == indice
}

/**
 * Checks if the receiver numbers form a pandigital number _(fyi. the concatenation of all 3 numbers)_.
 *
 * @see [isPandigital]
 *
 * @return true if the receiver numbers form a pandigital number
 */
fun Tuple3<Long, Long, Long>.isPandigital() = this.let { (a, b, c) ->
    "$a$b$c".toLong().isPandigital()
}

/**
 * Checks if the receiver numbers form a pandigital number of a specified indice.
 *
 * @see [isPandigital]
 *
 * @return true if the receiver numbers form a pandigital number of a specified indice
 */
fun Tuple3<Long, Long, Long>.isPandigital(indice: Int) = this.isPandigital() && this.let { (a, b, c) ->
    "$a$b$c".length == indice
}

/**
 * Returns the next number while applying the Collatz problem from the receiver _(eg. a formula to apply depending if the receiver is even or odd)_.
 *
 * _Reference: [http://mathworld.wolfram.com/CollatzProblem.html]_
 *
 * @return the next collatz number from the receiver
 */
fun Long.nextCollatz() = when {
    this == 1L -> 1L
    this.isEven() -> this / 2
    else -> 3 * this + 1
}

/**
 * Checks if the receiver number is a Circular Prime _(eg. is prime and all circular numbers are primes)_.
 *
 * _Reference: [http://mathworld.wolfram.com/CircularPrime.html]_
 *
 * @see [circularNumbers]
 *
 * @return true if the receiver number is a circular prime
 */
fun Long.isCircularPrime() = when {
    this < 10L -> this.isPrime()
    !this.isPrime() -> false
// First check for filtering: if it contains an even number, it won't be a circular prime.
// Then we compute the circular numbers and check for primes.
// Could be enhanced with some cache probably.
    else -> this.digits().all { it.isOdd() } && this.circularNumbers().all { it.isPrime() }
}