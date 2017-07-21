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

    @Test
    fun testDivisors() {
        assertThat(28L.numberOfDivisors()).isEqualTo(6)
    }

    @Test
    fun testFactorial() {
        assertThat(10.toBigInteger().factorial()).isEqualTo(3628800.toBigInteger())
    }

    @Test
    fun testSumDigits() {
        assertThat(sumDigits(1234.toBigInteger())).isEqualTo(10)
    }

    @Test
    fun testProperDivisors() {
        assertThat(220L.properDivisors()).containsExactly(1L, 2L, 4L, 5L, 10L, 11L, 20L, 22L, 44L, 55L, 110L)
        assertThat(284L.properDivisors()).containsExactly(1L, 2L, 4L, 71L, 142L)
    }

    @Test
    fun testAmicablePair() {
        // I know `isEqualTo` checks for nullity. But adding the `isNotNull` call helps for documenting how the method works
        assertThat(220L.amicablePair()).isNotNull().isEqualTo(284L)
        assertThat(284L.amicablePair()).isNotNull().isEqualTo(220L)
        assertThat(123L.amicablePair()).isNull()
    }

    @Test
    fun testPerfectNumbers() {
        assertThat(28L.isPerfect()).isTrue()
        assertThat(27L.isPerfect()).isFalse()
    }

    @Test
    fun testDeficientNumbers() {
        assertThat(14L.isDeficient()).isTrue()
        assertThat(28L.isDeficient()).isFalse()
        assertThat(12L.isDeficient()).isFalse()
    }

    @Test
    fun testAbundantNumbers() {
        assertThat(12L.isAbundant()).isTrue()
        assertThat(28L.isAbundant()).isFalse()
    }

}