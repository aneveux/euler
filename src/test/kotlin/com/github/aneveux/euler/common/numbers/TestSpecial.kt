package com.github.aneveux.euler.common.numbers

import io.vavr.Tuple3
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestSpecial {
    @Test
    fun testIsPrime() {
        assertThat(3L.isPrime()).isTrue()
        assertThat(4L.isPrime()).isFalse()
    }

    @Test
    fun testNumberIsPalindromic() {
        assertThat(1991L.isPalindromic()).isTrue()
        assertThat(1L.isPalindromic()).isTrue()
        assertThat(18L.isPalindromic()).isFalse()
    }

    @Test
    fun testPythagoreanTriple() {
        assertThat(Tuple3(3L, 4L, 5L).isPythagoreanTriple()).isTrue()
        assertThat(Tuple3(3L, 4L, 6L).isPythagoreanTriple()).isFalse()
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

    @Test
    fun testAmicablePair() {
        // I know `isEqualTo` checks for nullity. But adding the `isNotNull` call helps for documenting how the method works
        assertThat(220L.amicablePair()).isNotNull.containsExactly(284L)
        assertThat(284L.amicablePair()).isNotNull.containsExactly(220L)
        assertThat(123L.amicablePair()).isEmpty()
    }

    @Test
    fun testIsPandigital() {
        assertThat(123L.isPandigital()).isTrue()
        assertThat(1123L.isPandigital()).isFalse()
        assertThat(1L.isPandigital()).isTrue()
        assertThat(0L.isPandigital()).isFalse()
        assertThat(123456789L.isPandigital()).isTrue()
        assertThat(12345679L.isPandigital()).isFalse()

        assertThat(1324L.isPandigital(4)).isTrue()
        assertThat(1245L.isPandigital(4)).isFalse()
        assertThat(123456L.isPandigital(4)).isFalse()
    }

    @Test
    fun testTupleIsPandigital() {
        assertThat(Tuple3(1L, 2L, 3L).isPandigital()).isTrue()
        assertThat(Tuple3(1L, 2L, 4L).isPandigital()).isFalse()
        assertThat(Tuple3(123L, 45L, 6L).isPandigital()).isTrue()
        assertThat(Tuple3(12L, 34L, 5L).isPandigital(5)).isTrue()
        assertThat(Tuple3(12L, 34L, 5L).isPandigital(6)).isFalse()
    }

    @Test
    fun testCircularPrimes() {
        assertThat(2L.isCircularPrime()).isTrue()
        assertThat(3L.isCircularPrime()).isTrue()
        assertThat(4L.isCircularPrime()).isFalse()
        assertThat(17L.isCircularPrime()).isTrue()
        assertThat(19L.isCircularPrime()).isFalse()
        assertThat(197L.isCircularPrime()).isTrue()
    }
}