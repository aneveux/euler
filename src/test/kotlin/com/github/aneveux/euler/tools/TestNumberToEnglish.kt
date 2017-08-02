package com.github.aneveux.euler.tools

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class TestNumberToEnglish {

    @Test
    fun testUnitsConversion() {
        assertThat(1.toEnglish()).isEqualTo("one")
        assertThat(2.toEnglish()).isEqualTo("two")
        assertThat(3.toEnglish()).isEqualTo("three")
        assertThat(4.toEnglish()).isEqualTo("four")
        assertThat(5.toEnglish()).isEqualTo("five")
        assertThat(6.toEnglish()).isEqualTo("six")
        assertThat(7.toEnglish()).isEqualTo("seven")
        assertThat(8.toEnglish()).isEqualTo("eight")
        assertThat(9.toEnglish()).isEqualTo("nine")
    }

    @Test
    fun testTeensConversion() {
        assertThat(10.toEnglish()).isEqualTo("ten")
        assertThat(11.toEnglish()).isEqualTo("eleven")
        assertThat(12.toEnglish()).isEqualTo("twelve")
        assertThat(13.toEnglish()).isEqualTo("thirteen")
        assertThat(14.toEnglish()).isEqualTo("fourteen")
        assertThat(15.toEnglish()).isEqualTo("fifteen")
        assertThat(16.toEnglish()).isEqualTo("sixteen")
        assertThat(17.toEnglish()).isEqualTo("seventeen")
        assertThat(18.toEnglish()).isEqualTo("eighteen")
        assertThat(19.toEnglish()).isEqualTo("nineteen")
    }

    @Test
    fun testTensConversion() {
        assertThat(20.toEnglish()).isEqualTo("twenty")
        assertThat(21.toEnglish()).isEqualTo("twenty-one")
        assertThat(30.toEnglish()).isEqualTo("thirty")
        assertThat(33.toEnglish()).isEqualTo("thirty-three")
        assertThat(40.toEnglish()).isEqualTo("forty")
        assertThat(42.toEnglish()).isEqualTo("forty-two")
        assertThat(50.toEnglish()).isEqualTo("fifty")
        assertThat(55.toEnglish()).isEqualTo("fifty-five")
        assertThat(60.toEnglish()).isEqualTo("sixty")
        assertThat(68.toEnglish()).isEqualTo("sixty-eight")
        assertThat(70.toEnglish()).isEqualTo("seventy")
        assertThat(75.toEnglish()).isEqualTo("seventy-five")
        assertThat(80.toEnglish()).isEqualTo("eighty")
        assertThat(81.toEnglish()).isEqualTo("eighty-one")
        assertThat(90.toEnglish()).isEqualTo("ninety")
        assertThat(99.toEnglish()).isEqualTo("ninety-nine")
    }

    @Test
    fun testHundredsConversion() {
        assertThat(100.toEnglish()).isEqualTo("one hundred")
        assertThat(101.toEnglish()).isEqualTo("one hundred and one")
        assertThat(110.toEnglish()).isEqualTo("one hundred and ten")
        assertThat(121.toEnglish()).isEqualTo("one hundred and twenty-one")
        assertThat(254.toEnglish()).isEqualTo("two hundred and fifty-four")
        assertThat(390.toEnglish()).isEqualTo("three hundred and ninety")
        assertThat(516.toEnglish()).isEqualTo("five hundred and sixteen")
    }

    @Test
    fun testThousandsConversion() {
        assertThat(1000.toEnglish()).isEqualTo("one thousand")
    }

}