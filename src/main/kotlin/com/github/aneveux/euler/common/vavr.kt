package com.github.aneveux.euler.common

import io.vavr.Tuple3

operator fun <T> Tuple3<T, *, *>.component1(): T = _1
operator fun <T> Tuple3<*, T, *>.component2(): T = _2
operator fun <T> Tuple3<*, *, T>.component3(): T = _3