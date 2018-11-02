package com.github.aneveux.euler.problems

import com.github.aneveux.euler.common.numbers.sumDigits
import com.github.aneveux.euler.common.numbers.toBigInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestProblem11 {
    private val problem = Problem11()

    @Test
    fun testProblem11Solution() {
        assertThat(problem.solve()).isEqualTo(70600674.toString())
    }
}

class TestProblem12 {
    private val problem = Problem12()

    @Test
    fun testProblem12Solution() {
        assertThat(problem.solve()).isEqualTo(76576500.toString())
    }
}

class TestProblem13 {
    private val problem = Problem13()

    @Test
    fun testProblem13Solution() {
        assertThat(problem.solve()).isEqualTo(5537376230.toString())
    }
}

class TestProblem14 {
    private val problem = Problem14()

    @Test
    fun testProblem14Solution() {
        assertThat(problem.solve()).isEqualTo(837799.toString())
    }
}

class TestProblem15 {
    private val problem = Problem15()

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
    private val problem = Problem16()

    @Test
    fun testProblem16Example() {
        assertThat(2L.toBigInteger().pow(15).sumDigits()).isEqualTo(26)
    }

    @Test
    fun testProblem16Solution() {
        assertThat(problem.solve()).isEqualTo(1366.toString())
    }
}

class TestProblem17 {
    private val problem = Problem17()

    @Test
    fun testProblem17Example() {
        assertThat(problem.numberLettersCount(1..5)).isEqualTo(19)
    }

    @Test
    fun testProblem17Solution() {
        assertThat(problem.solve()).isEqualTo(21124.toString())
    }
}

class TestProblem18 {
    private val problem = Problem18()

    @Test
    fun testProblem18Solution() {
        assertThat(problem.solve()).isEqualTo(1074.toString())
    }
}

class TestProblem19 {
    private val problem = Problem19()

    @Test
    fun testProblem19Solution() {
        assertThat(problem.solve()).isEqualTo(171.toString())
    }
}

class TestProblem20 {
    private val problem = Problem20()

    @Test
    fun testProblem20Example() {
        assertThat(problem.sumDigitsFactorial(10)).isEqualTo(27)
    }

    @Test
    fun testProblem20Solution() {
        assertThat(problem.solve()).isEqualTo(648.toString())
    }
}