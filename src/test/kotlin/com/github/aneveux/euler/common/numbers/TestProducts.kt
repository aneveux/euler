package com.github.aneveux.euler.common.numbers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestProducts {
    @Test
    fun testProducts() {
        assertThat((2L..4L).products((2L..4L))).containsExactly(4, 6, 8, 6, 9, 12, 8, 12, 16)
    }

    @Test
    fun testIsEvenlyDivisibleBy() {
        assertThat(2520L.isEvenlyDivisibleBy((1L..10))).isTrue()
        assertThat(2519L.isEvenlyDivisibleBy((1L..10))).isFalse()
    }

    @Test
    fun testFactorial() {
        assertThat(10L.toBigInteger().factorial()).isEqualTo(3628800L.toBigInteger())
    }

    @Test
    fun testNumberDivisors() {
        assertThat(28L.numberOfDivisors()).isEqualTo(6)
    }

    @Test
    fun testProperDivisors() {
        assertThat(220L.properDivisors()).containsExactly(1L, 2L, 4L, 5L, 10L, 11L, 20L, 22L, 44L, 55L, 110L)
        assertThat(284L.properDivisors()).containsExactly(1L, 2L, 4L, 71L, 142L)
    }

    @Test
    fun testPrimeFactorsExample() {
        assertThat(13195L.primeFactors()).containsExactly(5, 7, 13, 29)
    }
}