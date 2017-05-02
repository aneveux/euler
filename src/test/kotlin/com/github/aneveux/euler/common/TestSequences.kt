package com.github.aneveux.euler.common

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestSequences {

    @Test
    fun testFibonnaciExample() {
        assertThat(fibonacci.take(10).iterator()).containsExactly(1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
    }

}