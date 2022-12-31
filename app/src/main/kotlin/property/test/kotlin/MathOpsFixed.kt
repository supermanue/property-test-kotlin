package com.newrelic.propertytesttutorial.lib

object MathOpsFixed {
    /*
    two different ways of dealing with the corner case
     */

    fun lengthProportion(a: String, b: String): Int? =
        if (b.isEmpty()) null
        else a.length / b.length

    fun smallerInt(a: Int): Int {
        if (a == Int.MIN_VALUE) throw ForbiddenInputException(a)
        return a - 1
    }

    class ForbiddenInputException(input: Int) : Exception("input $input is not valid")

}