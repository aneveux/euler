package com.github.aneveux.euler.problems.helpers

val zeroToNineteen = listOf("zero", "one", "two", "three", "four",
                            "five", "six", "seven", "eight", "nine",
                            "ten", "eleven", "twelve", "thirteen",
                            "fourteen", "fifteen", "sixteen",
                            "seventeen", "eighteen", "nineteen")

val tens = listOf("zero", "ten", "twenty", "thirty", "forty", "fifty",
                  "sixty", "seventy", "eighty", "ninety")

/**
 * Returns the receiver number written in english.
 *
 * Works only up to a thousand since it's enough for problem 17.
 *
 * @return the receiver number written in english
 */
fun Int.toEnglish(): String = when (this) {
    in (1..19) -> zeroToNineteen[this]
    in (20..90 step 10) -> tens[this / 10]
    in (21..99) -> (this / 10 * 10).toEnglish() + "-" + (this % 10).toEnglish()
    in (100..900 step 100) -> (this / 100).toEnglish() + " hundred"
    in (101..999) -> (this / 100).toEnglish() + " hundred and " + (this % 100).toEnglish()
    1_000 -> "one thousand"
    else -> ""
}