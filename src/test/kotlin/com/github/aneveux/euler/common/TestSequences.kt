package com.github.aneveux.euler.common

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestSequences {

    @Test
    fun testFibonnaciExample() {
        assertThat(fibonacci.take(10).iterator()).containsExactly(1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
    }

    @Test
    fun testTrianglesExample() {
        assertThat(triangles.take(7).toList()).containsExactly(1, 3, 6, 10, 15, 21, 28)
    }

    @Test
    fun testCollatzSequenceExample() {
        assertThat(13L.collatzSequence().toList()).containsExactly(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
    }

}