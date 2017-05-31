package com.github.aneveux.euler.problems

import com.github.aneveux.euler.common.pow
import com.github.aneveux.euler.common.toBigInteger
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
        assertThat(problem.solve()).isEqualTo(76576500.toString())
    }
}

class TestProblem13 {
    val problem = Problem13()

    @Test
    fun testProblem13Solution() {
        assertThat(problem.solve()).isEqualTo(5537376230.toString())
    }
}

class TestProblem14 {
    val problem = Problem14()

    @Test
    fun testProblem14Solution() {
        assertThat(problem.solve()).isEqualTo(837799.toString())
    }
}

class TestProblem15 {
    val problem = Problem15()

    @Test
    fun testLatticePathExample() {
        assertThat(problem.latticePath(2, 2)).isEqualTo(6)
    }

    @Test
    fun testProblem15Solution() {
        assertThat(problem.solve()).isEqualTo(137846528820.toString())
    }
}

class TestProblem16 {
    val problem = Problem16()

    @Test
    fun testProblem16Example() {
        assertThat(problem.sumDigits(2.toBigInteger().pow(15))).isEqualTo(26)
    }

    @Test
    fun testProblem16Solution() {
        assertThat(problem.solve()).isEqualTo(1366.toString())
    }
}