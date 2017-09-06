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

class TestProblem32 {
    val problem = Problem32()

    @Test
    fun testProblem32Solution() {
        assertThat(problem.solve()).isEqualTo(45228.toString())
    }
}

class TestProblem33 {
    val problem = Problem33()

    @Test
    fun testProblem33Solution() {
        assertThat(problem.solve()).isEqualTo(100.toString())
    }
}

class TestProblem34 {
    val problem = Problem34()

    @Test
    fun testHasFactorialDigits() {
        with(problem) {
            assertThat(145L.hasFactorialDigits()).isTrue()
            assertThat(2L.hasFactorialDigits()).isTrue()
            assertThat(24L.hasFactorialDigits()).isFalse()
        }
    }

    @Test
    fun testProblem34Solution() {
        assertThat(problem.solve()).isEqualTo(40730.toString())
    }
}