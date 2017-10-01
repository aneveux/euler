package com.github.aneveux.euler.common.numbers

/**
 * Returns the square of the receiver _(eg. this * this)_.
 *
 * _Reference: [http://mathworld.wolfram.com/SquareNumber.html]_
 *
 * @return the square of the receiver
 */
fun Long.square() = this * this

/**
 * Returns the square root of the receiver _(eg. from Math.sqrt)_.
 *
 * _Reference: [http://mathworld.wolfram.com/SquareRoot.html]_
 *
 * @return the square root of the receiver
 */
fun Double.squareRoot() = Math.sqrt(this)

/**
 * @see [Double.squareRoot]
 */
fun Double.sqrt() = this.squareRoot()

/**
 * @see [Double.squareRoot]
 */
fun Long.sqrt() = this.toDouble().sqrt()

/**
 * Returns the `p'th` power of the receiver _(eg. receiver power p)_.
 *
 * _Reference: [http://mathworld.wolfram.com/Power.html]_
 *
 * @return the receiver power p
 */
fun Long.pow(p: Long) = Math.pow(this.toDouble(), p.toDouble()).toLong()