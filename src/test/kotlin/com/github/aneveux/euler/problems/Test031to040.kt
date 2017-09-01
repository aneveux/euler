package com.github.aneveux.euler.problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class TestProblem31 {
    val problem = Problem31()

    @Test
    fun testCombinations() {
        with(problem) {
            // 1
            assertThat(combinations(1)).isEqualTo(1)
            // 1,1 || 2
            assertThat(combinations(2)).isEqualTo(2)
            // 1,1,1 || 2,1
            assertThat(combinations(3)).isEqualTo(2)
            // 1,1,1,1 || 2,1,1 || 2,2
            assertThat(combinations(4)).isEqualTo(3)
            // 1,1,1,1,1 || 2,1,1,1 || 2,1,1 || 5
            assertThat(combinations(5)).isEqualTo(4)
        }
    }

    @Test
    fun testProblem31Solution() {
        assertThat(problem.solve()).isEqualTo(73682.toString())
    }
}