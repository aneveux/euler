package com.github.aneveux.euler.common.sequences

import com.github.aneveux.euler.common.numbers.nextCollatz
import java.math.BigInteger

/**
 * An infinite sequence containing values of the Fibonacci sequence.
 *
 * _Reference: [http://mathworld.wolfram.com/FibonacciNumber.html]_
 */
val fibonacci = sequence {
    var a = 0L
    var b = 1L

    yield(1L)

    while (true) {
        yield(a + b)

        val tmp = a + b
        a = b
        b = tmp
    }
}

/**
 * An infinite sequence containing values of the Fibonacci sequence as [BigInteger].
 *
 * _Reference: [http://mathworld.wolfram.com/FibonacciNumber.html]_
 */
val big_fibonacci = sequence {
    var a = BigInteger.ZERO
    var b = BigInteger.ONE

    yield(BigInteger.ONE)

    while (true) {
        yield(a + b)
        val tmp = a + b
        a = b
        b = tmp
    }
}

/**
 * An infinite sequence containing triangular numbers _(eg. addition of all integers up to the index)_.
 *
 * _Reference: [http://mathworld.wolfram.com/TriangularNumber.html]_
 */
val triangles = sequence {
    var index = 1L
    var current = 0L
    while (true) {
        yield(current + index)
        current += index++
    }
}

/**
 * Returns a sequence containing all the elements according to the Collatz problem _(eg. formula to be applied depending if the current number is even or odd)_.
 *
 * _Reference: [http://mathworld.wolfram.com/CollatzProblem.html]_
 *
 * @return a sequence containing elements computed from the Collatz problem
 */
fun Long.collatzSequence() = sequence {
    var current = this@collatzSequence
    while (current != 1L) {
        yield(current)
        current = current.nextCollatz()
    }
    yield(1L)
}