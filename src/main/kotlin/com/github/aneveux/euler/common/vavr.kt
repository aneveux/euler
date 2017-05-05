package com.github.aneveux.euler.common

import javaslang.Tuple3

operator fun <T> Tuple3<T, *, *>.component1() = _1
operator fun <T> Tuple3<*, T, *>.component2() = _2
operator fun <T> Tuple3<*, *, T>.component3() = _3