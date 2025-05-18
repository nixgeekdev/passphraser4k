package dev.nixgeek.passphrases

import dev.nixgeek.passphrases.fixtures.FAKE_DICE_FACES_SIX
import dev.nixgeek.passphrases.fixtures.FAKE_DICE_FACES_TWENTY
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.comparables.shouldNotBeGreaterThan
import io.kotest.matchers.comparables.shouldNotBeLessThan
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class RandomSpec :
    FunSpec({
        context("successful six-faced dice rolls") {
            withData(
                (4..5).map { it },
            ) { howMany ->
                val result = rollDices(howMany, FAKE_DICE_FACES_SIX)
                result.length shouldNotBeGreaterThan howMany
                result.toInt() shouldNotBeLessThan 1111
                result.toInt() shouldNotBeGreaterThan 66666
            }
        }

        context("successful twenty-faced dice rolls") {
            withData(
                (0..4).map { rollDices(3, FAKE_DICE_FACES_TWENTY) },
            ) { result ->
                result.length shouldNotBeGreaterThan 8
                result.filter { it == '-' }.length shouldBe 2
                for (value in result.split("-").map { it.toInt() }) {
                    value shouldBeInRange (1..20)
                }
            }
        }

        context("dice type parameter failures") {
            withData(
                listOf(3, 5, 7, 9, 11, 13, 14, 15, 16, 17, 18, 19, 21).map { it },
            ) { faces ->
                shouldThrow<IllegalArgumentException> {
                    rollDice(faces)
                }
            }
        }

        context("dice number of rolls parameter failures") {
            withData(
                listOf(0, 6, 7, 8, 9).map { it },
            ) { howMany ->
                shouldThrow<IllegalArgumentException> {
                    rollDices(howMany, FAKE_DICE_FACES_SIX)
                }
            }
        }
    })
