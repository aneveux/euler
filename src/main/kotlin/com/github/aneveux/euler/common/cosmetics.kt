package com.github.aneveux.euler.common

inline fun <T> timer(block: () -> T): Pair<T, Long> {
    val start = System.currentTimeMillis()
    val t = block()
    val end = System.currentTimeMillis()

    return t to (end - start)
}

fun String.print() = println(this)

fun Pair<String, Long>.print() = println("Result= [$first] (in $second ms)")