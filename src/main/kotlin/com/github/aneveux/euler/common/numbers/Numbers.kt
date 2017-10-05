package com.github.aneveux.euler.common.numbers

import com.github.aneveux.euler.common.sequences.replicate
import java.math.BigInteger
import io.vavr.collection.List as VList

/**
 * Returns the Int value actually contained in a Char, and not the int matching the Char.
 *
 * Yup. Kinda hard to explain. Anyway, if the Char contains 1 and you call `toInt` it'll return 49.
 *
 * We want it to return 1.
 *
 * @return the value of the actual Int contained in the Char
 */
fun Char.toIntValue(): Int =
        if (this !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        else this.toInt() - '0'.toInt()

/**
 * Returns a BigInteger value of the receiver.
 *
 * @return a BigInteger from the receiver
 */
fun Long.toBigInteger(): BigInteger = BigInteger.valueOf(this)

/**
 * Checks if a number is even _(eg. multiple of 2)_.
 *
 * @return true if the receiver is an even number
 */
fun Number.isEven() = this.toLong() isMultipleOf 2

/**
 * Checks if a number is odd _(eg. not multiple of 2)_.
 *
 * @return true if the receiver is an odd number
 */
fun Number.isOdd() = !this.isEven()

/**
 * Returns the integer part of the receiver _(eg. removes the decimal part)_.
 *
 * Example: `10.25 becomes 10`
 *
 * _Reference: [http://mathworld.wolfram.com/FloorFunction.html]_
 *
 * @return the integer part of the receiver
 */
fun Double.floor() = this.toLong()

/**
 * Returns a List containing all the receiver's digits.
 *
 * @return a list of all the receiver's digits
 */
fun Long.digits() = this.toString().map(Char::toIntValue)

/**
 * Returns a List containing all the receiver's digits.
 *
 * @return a list of all the receiver's digits
 */
fun BigInteger.digits() = this.toString().map(Char::toIntValue)

/**
 * Returns a List containing all the circular numbers from the receiver's digits _(eg. rotating the number around a circle)_.
 *
 * Example: `Circular numbers of 123 are 231 and 312`
 *
 * @return a List containing all circular numbers of the receiver's digits
 */
fun Long.circularNumbers() = this.digits().let { digits ->
    VList.ofAll(digits.replicate(2).flatten())
            .sliding(digits.size)
            .toList()
            .map { it.joinToString(postfix = "", prefix = "", separator = "") { "$it" } }
            .map { it.toLong() }
            .removeAll(this)
}

/**
 * Returns a Binary conversion of the receiver number.
 *
 * _Reference: [http://mathworld.wolfram.com/Binary.html]_
 *
 * @return the receiver number in base 2
 */
fun Long.toBinary() = Integer.toBinaryString(this.toInt())