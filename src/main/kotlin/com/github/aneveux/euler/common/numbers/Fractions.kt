package com.github.aneveux.euler.common.numbers

/**
 * Returns the greatest common factor (or divisor) of the receiver numbers.
 *
 * _Reference: [http://mathworld.wolfram.com/GreatestCommonDivisor.html]_
 *
 * @return the greatest common factor of the receiver numbers
 */
fun Pair<Int, Int>.greatestCommonFactor(): Int = this.let { (n, d) ->
    if (d == 0) n else (d to (n % d)).greatestCommonFactor()
}