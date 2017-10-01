package com.github.aneveux.euler.common.numbers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestSums {
    @Test
    fun testSumSquares() {
        assertThat((1L..10).sumSquares()).isEqualTo(385)
    }

    @Test
    fun testSquareSum() {
        assertThat((1L..10).squareSum()).isEqualTo(3025)
    }

    @Test
    fun testSumDigits() {
        assertThat(1234L.toBigInteger().sumDigits()).isEqualTo(10)
    }

    @Test
    fun testSumBelowPrimes() {
        assertThat(10L.sumBelowPrimes()).isEqualTo(17)
    }
}