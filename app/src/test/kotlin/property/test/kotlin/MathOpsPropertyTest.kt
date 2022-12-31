package com.newrelic.propertytesttutorial.lib

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.string
import io.kotest.property.forAll

class MathOpsPropertyTest : StringSpec({
    "lengthProportion computes the proportion between two strings (test fails because of corner case)" {
        forAll(Arb.string(), Arb.string()) { a, b ->
            MathOps.lengthProportion(a, b) >= 0
        }
    }

    "smallerInt returns an integer smaller than the input (test fails because of corner case)" {
        forAll(Arb.int()) { a -> MathOps.smallerInt(a) < a }
    }
})