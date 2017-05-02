package com.github.aneveux.euler

import com.github.aneveux.euler.common.print
import com.github.aneveux.euler.common.timer
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

abstract class Problem {
    abstract fun solve(): String
}

object Problems {
    var problems: List<Pair<String, KClass<out Problem>>>

    init {
        val reflectionConfiguration = ConfigurationBuilder().apply {
            addUrls(ClasspathHelper.forPackage("${this.javaClass.`package`}.problems"))
            addUrls(ClasspathHelper.forClass(Problem::class.java))
        }.setScanners(SubTypesScanner())
        problems = Reflections(reflectionConfiguration).getSubTypesOf(Problem::class.java)
                .map { Pair(it.name.substringAfterLast("Problem"), it.kotlin) }
    }

    fun solve(vararg numbers: Int) = numbers.map(Int::toString)
            .forEach {
                problems.filter { (n, _) -> n == it }.map { (_, klass) -> klass }
                        .first().apply {
                    val problem = objectInstance ?: this.primaryConstructor?.call()
                    if (problem != null) {
                        print("Problem $it: ")
                        timer { problem.solve() }.print()
                    }
                }
            }
}

fun main(args: Array<String>) {
    Problems.solve(*args.map { it.toInt() }.toIntArray())
}