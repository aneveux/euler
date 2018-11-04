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

    @Test
    fun testCircularNumbers() {
        assertThat(123L.circularNumbers()).containsExactly(231, 312)
        assertThat(1L.circularNumbers()).isEmpty()
        assertThat(15L.circularNumbers()).containsExactly(51)
        assertThat(6831L.circularNumbers()).containsExactly(8316, 3168, 1683)
    }

    @Test
    fun testToBinary() {
        assertThat(0L.toBinary()).isEqualTo("0")
        assertThat(1L.toBinary()).isEqualTo("1")
        assertThat(2L.toBinary()).isEqualTo("10")
        assertThat(3L.toBinary()).isEqualTo("11")
        assertThat(4L.toBinary()).isEqualTo("100")
    }

    @Test
    fun testListAsNumber() {
        assertThat(listOf(1,2,3,4,5).asNumber()).isEqualTo(12345L)
        assertThat(listOf(1).asNumber()).isEqualTo(1L)
        assertThat(listOf(0,0,0,1).asNumber()).isEqualTo(1L)
    }
}