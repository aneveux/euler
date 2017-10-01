package com.github.aneveux.euler.common.helpers

/**
 * Executes a block of code while measuring the time it takes to execute. Returns a Pair containing the result as well as the milliseconds it took to execute.
 *
 * @return a Pair containing the result of the provided lambda and the number of milliseconds it took to execute
 */
inline fun <T> timer(block: () -> T): Pair<T, Long> {
    val start = System.currentTimeMillis()
    val t = block()
    val end = System.currentTimeMillis()

    return t to (end - start)
}

/**
 * Prints on the screen the result of a block of code executed through [timer] (which returns a Pair of result -> time).
 */
fun Pair<String, Long>.print() = println("Result= [$first] (in $second ms)")