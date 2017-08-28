package com.github.aneveux.euler.common

import io.vavr.collection.Stream

fun <T> T.replicate(occurences: Int): Stream<T> = Stream.fill(occurences) { this }