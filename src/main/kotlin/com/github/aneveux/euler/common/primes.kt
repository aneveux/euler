package com.github.aneveux.euler.common

fun Number.isPrime() = with(this.toLong()) {
    this > 1 && (2..this.sqrtRange()).all { !(this isMultipleOf it) }
}

fun Number.primeFactors(): List<Long> = with(this.toLong()) {
    if (isPrime()) listOf(this)
    else {
        val nextPrimeFactor = (2..this.sqrtRange()).find { this isMultipleOf it && it.isPrime() }
        if (nextPrimeFactor == null) emptyList()
        else listOf(nextPrimeFactor) + (this / nextPrimeFactor).primeFactors()
    }
}

fun Long.sumBelowPrimes() = primes.takeWhile { it < this.toBigInteger() }.sum().toLong()