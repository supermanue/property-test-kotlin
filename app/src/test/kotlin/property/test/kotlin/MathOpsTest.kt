package com.newrelic.propertytesttutorial.lib

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class MathOpsTest : StringSpec({

    "lengthProportion calculates the proportion between two strings" {
        val str1 = "1234"
        val str2 = "12"
        MathOps.lengthProportion(str1, str2) shouldBe 2
    }

    "smallerInt returns an smaller int" {
        val a = 17
        (MathOps.smallerInt(a) < a) shouldBe true
    }

    "lengthProportion has an uncovered edge case" {
        val str1 = "1234"
        val str2 = ""
        MathOps.lengthProportion(str1, str2) shouldBe 2
    }

    "smallerInt has an uncovered edge case" {
        val a = Int.MIN_VALUE
        ( MathOps.smallerInt(a) < a) shouldBe true
    }

})