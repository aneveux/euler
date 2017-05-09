package com.github.aneveux.euler.problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestProblem11 {
    val problem = Problem11()

    @Test
    fun testProblem11Solution() {
        assertThat(problem.solve()).isEqualTo(70600674.toString())
    }
}

class TestProblem12 {
    val problem = Problem12()

    @Test
    fun testProblem12Solution() {
        assertThat(problem.solve()).isEqualTo(0.toString())
    }
}