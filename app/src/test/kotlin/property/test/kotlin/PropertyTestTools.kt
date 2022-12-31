package com.newrelic.propertytesttutorial.lib

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.*
import io.kotest.property.forAll

class PropertyTestTools : StringSpec({
    "generate a single input" {
        val randomInt = Arb.int().next()
        randomInt shouldBe randomInt
    }

    "add restrictions to the generated samples: odd numbers" {
        forAll(Arb.int().filter { it % 4 == 0 }) { a -> a % 2 == 0 }
    }

    "get all edge cases for a particular generator" {
        val edgeCasesForInts: Set<Int> = Arb.int().edgecases()
        val edgeCasesForStrings: Set<String> = Arb.string().edgecases()

        edgeCasesForInts shouldNotBe emptySet<Int>()
        edgeCasesForStrings shouldNotBe emptySet<String>()
    }

    "run the tests a limited number of times" {
        forAll(iterations = 3, Arb.int()) { a -> a != a + 1 }
    }
})