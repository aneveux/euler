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

class TestProblem23 {
    val problem = Problem23()

    @Test
    fun testFilterAbundantNumbers() {
        with(problem) {
            assertThat((0L..30L).abundantNumbers()).containsExactly(12L, 18L, 20L, 24L, 30L)
        }
    }

    @Test
    fun testProblem23Solution() {
        assertThat(problem.solve()).isEqualTo(4179871.toString())
    }
}

class TestProblem24 {
    val problem = Problem24()

    @Test
    fun testComputePermutations() {
        with(problem) {
            assertThat(computePermutations('0', '1', '2')).containsExactly("012", "021", "102", "120", "201", "210")
        }
    }

    @Test
    fun testProblem24Solution() {
        assertThat(problem.solve()).isEqualTo(2783915460.toString())
    }
}

class TestProblem25 {
    val problem = Problem25()

    @Test
    fun testProblem25Solution() {
        assertThat(problem.solve()).isEqualTo(4782.toString())
    }
}

class TestProblem26 {
    val problem = Problem26()

    @Test
    fun testMultiplicativeOrder() {
        with (problem) {
            assertThat(multiplicativeOrder(2)).isEqualTo(1)
            assertThat(multiplicativeOrder(3)).isEqualTo(1)
            assertThat(multiplicativeOrder(4)).isEqualTo(2)
            assertThat(multiplicativeOrder(5)).isEqualTo(1)
            assertThat(multiplicativeOrder(6)).isEqualTo(0)
            assertThat(multiplicativeOrder(7)).isEqualTo(6)
            assertThat(multiplicativeOrder(8)).isEqualTo(3)
            assertThat(multiplicativeOrder(9)).isEqualTo(1)
            assertThat(multiplicativeOrder(10)).isEqualTo(1)
        }
    }

    @Test
    fun testProblem26Solution() {
        assertThat(problem.solve()).isEqualTo(983.toString())
    }
}