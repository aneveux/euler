package com.github.aneveux.euler.common.numbers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestNumbers {
    @Test
    fun testDigits() {
        assertThat(1L.digits()).containsExactly(1)
        assertThat(1234L.digits()).containsExactly(1, 2, 3, 4)
    }

    @Test
    fun testBigDigits() {
        assertThat(1234L.toBigInteger().digits()).containsExactly(1, 2, 3, 4)
    }

    @Test
    fun testFloor() {
        assertThat(2.25.floor()).isEqualTo(2L)
    }
}