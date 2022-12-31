package com.newrelic.propertytesttutorial.lib

object MathOps {
    fun lengthProportion(a: String, b: String): Int = a.length / b.length
    fun smallerInt(a: Int): Int = a - 1
}