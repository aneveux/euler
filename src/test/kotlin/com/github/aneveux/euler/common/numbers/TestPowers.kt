package com.github.aneveux.euler.common.numbers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestPowers {
    @Test
    fun testSquare() {
        assertThat(0L.square()).isEqualTo(0L)
        assertThat(4L.square()).isEqualTo(16L)
    }

    @Test
    fun testSquareRoot() {
        assertThat(16.0.squareRoot()).isEqualTo(4.0)
        assertThat(0.0.sqrt()).isEqualTo(0.0)
        assertThat(25L.sqrt()).isEqualTo(5.0)
    }

    @Test
    fun testPow() {
        assertThat(2L.pow(0)).isEqualTo(1L)
        assertThat(2L.pow(3L)).isEqualTo(8L)
    }
}