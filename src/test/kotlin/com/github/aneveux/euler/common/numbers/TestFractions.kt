package com.github.aneveux.euler.common.numbers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestFractions {
    @Test
    fun testGreatestCommonFactor() {
        assertThat((4 to 4).greatestCommonFactor()).isEqualTo(4)
        assertThat((8 to 4).greatestCommonFactor()).isEqualTo(4)
        assertThat((4 to 8).greatestCommonFactor()).isEqualTo(4)
        assertThat((3 to 4).greatestCommonFactor()).isEqualTo(1)
        assertThat((1 to 2).greatestCommonFactor()).isEqualTo(1)
    }
}