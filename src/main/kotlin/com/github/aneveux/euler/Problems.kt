package com.github.aneveux.euler

import com.github.aneveux.euler.common.helpers.print
import com.github.aneveux.euler.common.helpers.timer
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

/**
 * Just a Simple convention I gave to myself: an Euler Problem consists in a simple class with at least one [solve] method returning the result as a [String].
 */
abstract class Problem {
    /**
     * Returns the result of the current Euler problem.
     */
    abstract fun solve(): String
}

/**
 * Simple helper object allowing to find all the implemented Euler problems thanks to reflection in the source code, executing them, and displaying the result on the console.
 *
 * Probably useless, that's why I needed to implement it so much.
 */
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

/**
 * Provide as arguments to this main method all the problems you'd like to solve in the form of Integers, and you'll get the results of all these problems displayed on the screen.
 */
fun main(args: Array<String>) {
    Problems.solve(*args.map { it.toInt() }.toIntArray())
}