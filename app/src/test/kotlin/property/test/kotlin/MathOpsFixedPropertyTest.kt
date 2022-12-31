package com.newrelic.propertytesttutorial.lib

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.string
import io.kotest.property.forAll
import org.junit.jupiter.api.assertThrows

class MathOpsFixedPropertyTest : StringSpec({
    "lengthProportion computes the proportion between two strings if the denominator is not empty" {
        forAll(Arb.string(), Arb.string(minSize = 1)) { a, b ->
            MathOpsFixed.lengthProportion(a, b)!! >= 0
        }
    }

    "lengthProportion returns null if the denominator is not empty" {
        forAll(Arb.string()) { a ->
            MathOpsFixed.lengthProportion(a, "") == null
        }
    }

    "smallerInt returns an integer smaller than the input" {
        forAll(Arb.int(min = Int.MIN_VALUE + 1)) { a -> MathOpsFixed.smallerInt(a) < a }
    }

    "smallerInt returns an exception if the input is not supported" {
        assertThrows<MathOpsFixed.ForbiddenInputException> { MathOpsFixed.smallerInt(Int.MIN_VALUE) }
    }
})