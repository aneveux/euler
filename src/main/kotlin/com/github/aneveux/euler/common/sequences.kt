package com.github.aneveux.euler.common

import kotlin.coroutines.experimental.buildSequence

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