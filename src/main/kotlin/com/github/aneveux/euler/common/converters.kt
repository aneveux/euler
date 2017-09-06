package com.github.aneveux.euler.common

import java.math.BigInteger

fun Number.toBigInteger(): BigInteger = BigInteger.valueOf(this.toLong())

fun Char.toIntValue(): Int =
        if (this !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        else this.toInt() - '0'.toInt()

fun Long.digits() = this.toString().map { it.toString().toLong() }