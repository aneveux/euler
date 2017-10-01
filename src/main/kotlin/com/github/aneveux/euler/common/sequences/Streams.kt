package com.github.aneveux.euler.common.sequences

import io.vavr.collection.Stream
import java.math.BigInteger

/**
 * Returns a Stream containing n occurences of the receiver element.
 *
 * @return a Stream with n occurences of the receiver
 */
fun <T> T.replicate(occurences: Int): Stream<T> = Stream.fill(occurences) { this }

/**
 * Returns an infinite Stream of BigInteger containing prime numbers, based on [BigInteger.nextProbablePrime] generator.
 *
 * _Reference: [http://mathworld.wolfram.com/PrimeNumber.html]_
 *
 * @return an infinite Stream of prime numbers
 */
val primes: Stream<BigInteger> = Stream.iterate(BigInteger("2")) { it.nextProbablePrime() }