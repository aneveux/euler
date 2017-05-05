package com.github.aneveux.euler.common

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestPrimes {

    @Test
    fun testIsPrime() {
        assertThat(3L.isPrime()).isTrue()
        assertThat(4L.isPrime()).isFalse()
    }

    @Test
    fun testPrimeFactorsExample() {
        assertThat(13195L.primeFactors()).containsExactly(5, 7, 13, 29)
    }

    @Test
    fun testPrimesSum() {
        assertThat(10L.sumBelowPrimes()).isEqualTo(17)
    }

}