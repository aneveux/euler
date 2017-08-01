package com.github.aneveux.euler.common

import io.vavr.collection.Stream
import java.math.BigInteger
import kotlin.coroutines.experimental.buildSequence

val primes: Stream<BigInteger> = Stream.iterate(BigInteger("2")) { it.nextProbablePrime() }

val fibonacci = buildSequence {
    var a = 0
    var b = 1

    yield(1)

    while (true) {
        yield(a + b)

        val tmp = a + b
        a = b
        b = tmp
    }
}

val triangles = buildSequence {
    var index = 1
    var current = 0
    while (true) {
        yield(current + index)

        current += index++
    }
}

fun Long.collatzSequence() = buildSequence {
    var current = this@collatzSequence
    while (current != 1L) {
        yield(current)
        current = current.nextCollatz()
    }
    yield(1L)
}

fun Long.nextCollatz() = when {
    this == 1L -> 1L
    this.isEven() -> this / 2
    else -> 3 * this + 1
}