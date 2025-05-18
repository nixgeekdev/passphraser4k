package dev.nixgeek.passphrases.wordlists

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WordlistContextFactorySpec :
    FunSpec({
        test("available wordlists") {
            WordlistContextFactory.availableContextIds() shouldBe Wordlists.entries.map { it.id }
        }
    })
