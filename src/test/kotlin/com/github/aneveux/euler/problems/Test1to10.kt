package com.github.aneveux.euler.problems

import com.github.aneveux.euler.common.primes
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestProblem1 {
    val problem = Problem1()

    @Test
    fun testProblem1Example() {
        assertThat(problem.sumMultiples(10)).isEqualTo(23L)
    }

    @Test
    fun testProblem1Solution() {
        assertThat(problem.solve()).isEqualTo(233168.toString())
    }
}

class TestProblem2 {
    val problem = Problem2()

    @Test
    fun testProblem2Solution() {
        assertThat(problem.solve()).isEqualTo(4613732.toString())
    }
}

class TestProblem3 {
    val problem = Problem3()

    @Test
    fun testProblem3Solution() {
        assertThat(problem.solve()).isEqualTo(6857.toString())
    }
}

class TestProblem4 {
    val problem = Problem4()

    @Test
    fun testProblem4Example() {
        assertThat(problem.largestPalindromeFromProducts((10L..99L))).isEqualTo(9009L)
    }

    @Test
    fun testProblem4Solution() {
        assertThat(problem.solve()).isEqualTo(906609.toString())
    }
}

class TestProblem5 {
    val problem = Problem5()

    @Test
    fun testProblem5Solution() {
        assertThat(problem.solve()).isEqualTo(232792560.toString())
    }
}

class TestProblem6 {
    val problem = Problem6()

    @Test
    fun testProblem6Example() {
        assertThat(problem.squareSumMinusSumSquares((1..10))).isEqualTo(2640)
    }

    @Test
    fun testProblem6Solution() {
        assertThat(problem.solve()).isEqualTo(25164150.toString())
    }
}

class TestProblem7 {
    val problem = Problem7()

    @Test
    fun testProblem7Example() {
        assertThat(primes.get(5).toInt()).isEqualTo(13)
    }

    @Test
    fun testProblem7Solution() {
        assertThat(problem.solve()).isEqualTo(104743.toString())
    }
}

class TestProblem8 {
    val problem = Problem8()

    @Test
    fun testProblem8Example() {
        assertThat(problem.maxProductOfAdjacentDigits(4L)).isEqualTo(5832L)
    }

    @Test
    fun testProblem8Solution() {
        assertThat(problem.solve()).isEqualTo(23514624000.toString())
    }
}

class TestProblem9 {
    val problem = Problem9()

    @Test
    fun testProblem9Solution() {
        assertThat(problem.solve()).isEqualTo(31875000.toString())
    }
}

class TestProblem10 {
    val problem = Problem10()

    @Test
    fun testProblem10Solution() {
        assertThat(problem.solve()).isEqualTo(142913828922.toString())
    }
}