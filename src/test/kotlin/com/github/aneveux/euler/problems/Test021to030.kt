package com.github.aneveux.euler.problems

import com.github.aneveux.euler.common.digits
import com.github.aneveux.euler.common.pow
import com.github.aneveux.euler.common.toBigInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

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
        with(problem) {
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

class TestProblem27 {
    val problem = Problem27()

    @Test
    fun testProblem27Solution() {
        assertThat(problem.solve()).isEqualTo((-59231).toString())
    }
}

class TestProblem28 {
    val problem = Problem28()

    @Test
    fun testProblem28Example() {
        with(problem) {
            assertThat(problem.spiralSum(5)).isEqualTo(101L)
        }
    }

    @Test
    fun testProblem28Solution() {
        assertThat(problem.solve()).isEqualTo(669171001.toString())
    }
}

class TestProblem29 {
    val problem = Problem29()

    @Test
    fun testProblem29Example() {
        with(problem) {
            assertThat((2..5).distinctPowers())
                    .containsOnly(*arrayOf(4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125)
                            .map { it.toBigInteger() }.toTypedArray())
        }
    }

    @Test
    fun testProblem29Solution() {
        assertThat(problem.solve()).isEqualTo(9183.toString())
    }
}

class TestProblem30 {
    val problem = Problem30()

    @Test
    fun testDigits() {
        with(problem) {
            assertThat(12345L.digits()).containsExactly(1L, 2L, 3L, 4L, 5L)
        }
    }

    @Test
    fun testSumDigitsPowersOf5() {
        with(problem) {
            assertThat(1L.sumDigitsPowersOf5()).isEqualTo(1L)
            assertThat(23L.sumDigitsPowersOf5()).isEqualTo(2L.pow(5) + 3L.pow(5))
        }
    }

    @Test
    fun testProblem30Solution() {
        assertThat(problem.solve()).isEqualTo(443839.toString())
    }
}