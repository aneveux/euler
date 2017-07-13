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