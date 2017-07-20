package com.github.aneveux.euler.problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestProblem21 {
    val problem = Problem21()

    @Test
    fun testProblem21Solution() {
        assertThat(problem.solve()).isEqualTo(31626.toString())
    }
}

class TestProblem22 {
    val problem = Problem22()

    @Test
    fun testStringScore() {
        with(problem) {
            assertThat("COLIN".score()).isEqualTo(53)
            assertThat("A".score()).isEqualTo(1)
            assertThat("ABCD".score()).isEqualTo(10)
        }
    }

    @Test
    fun testNameScores() {
        assertThat(problem.namesScores(listOf("COLIN"))).isEqualTo(53)
        assertThat(problem.namesScores(listOf("COLIN", "ABCD", "A"))).isEqualTo(1 + (2 * 10) + (3 * 53))
    }

    @Test
    fun testProblem22Solution() {
        assertThat(problem.solve()).isEqualTo(871198282.toString())
    }
}