package com.github.aneveux.euler.common

import javaslang.Tuple3
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestArithmetic {

    @Test
    fun testNumberIsPalindrome() {
        assertThat(1991L.isPalindrome()).isTrue()
        assertThat(1L.isPalindrome()).isTrue()
        assertThat(18L.isPalindrome()).isFalse()
    }

    @Test
    fun testProducts() {
        assertThat((2L..4L).products((2L..4L))).containsExactly(4, 6, 8, 6, 9, 12, 8, 12, 16)
    }

    @Test
    fun testIsEvenlyDivisibleBy() {
        assertThat(2520L.isEvenlyDivisibleBy((1..10))).isTrue()
        assertThat(2519L.isEvenlyDivisibleBy((1..10))).isFalse()
    }

    @Test
    fun testSumSquares() {
        assertThat((1..10).sumSquares()).isEqualTo(385)
    }

    @Test
    fun testSquareSum() {
        assertThat((1..10).squareSum()).isEqualTo(3025)
    }

    @Test
    fun testPythagoreanTriplet() {
        assertThat(Tuple3(3, 4, 5).isPythagoreanTriplet()).isTrue()
        assertThat(Tuple3(3, 4, 6).isPythagoreanTriplet()).isFalse()
    }

}