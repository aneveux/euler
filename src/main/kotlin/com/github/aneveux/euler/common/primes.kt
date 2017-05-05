package com.github.aneveux.euler.common

import javaslang.collection.Stream.iterate
import java.math.BigInteger

val primes = iterate(BigInteger("2")) { it.nextProbablePrime() }

fun Number.isPrime() = this.toLong() > 1L && (2L..(this.toLong() / 2L)).all { this.toLong() % it != 0L }

fun Number.primeFactors(): List<Long> =
        if (this.isPrime()) listOf(this.toLong())
        else {
            val nextPrimeFactor = (2L..(this.toLong() / 2L)).find { this.toLong() % it == 0L && it.isPrime() }
            if (nextPrimeFactor == null) emptyList()
            else listOf(nextPrimeFactor) + (this.toLong() / nextPrimeFactor).primeFactors()
        }

fun Long.sumBelowPrimes() = primes.takeWhile { it < this.toBigInteger() }.sum().toLong()