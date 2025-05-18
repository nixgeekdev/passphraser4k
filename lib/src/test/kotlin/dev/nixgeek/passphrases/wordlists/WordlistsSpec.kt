package dev.nixgeek.passphrases.wordlists

import dev.nixgeek.passphrases.fixtures.FAKE_WORDLIST_ID_BAR
import dev.nixgeek.passphrases.fixtures.FAKE_WORDLIST_ID_BAZ
import dev.nixgeek.passphrases.fixtures.FAKE_WORDLIST_ID_FOO
import dev.nixgeek.passphrases.fixtures.FAKE_WORDLIST_ID_QUX
import dev.nixgeek.passphrases.fixtures.FAKE_WORDLIST_FILE_REINHOLD
import dev.nixgeek.passphrases.fixtures.FAKE_WORDLIST_FILE_SUFFIX
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldStartWith

class WordlistsSpec :
    FunSpec({
        context("get wordlist by id is successful") {
            withData(
                Wordlists.entries.map { it.id },
            ) { id ->
                Wordlists.getByIdOrDefault(id) shouldBeIn Wordlists.entries
            }

            withData(
                FAKE_WORDLIST_ID_FOO,
                FAKE_WORDLIST_ID_BAR,
                FAKE_WORDLIST_ID_BAZ,
                FAKE_WORDLIST_ID_QUX,
            ) { id ->
                Wordlists.getByIdOrDefault(id) shouldBe Wordlists.DICEWARE_REINHOLD
            }
        }

        context("get wordlist file is successful") {
            withData(
                Wordlists.entries.map { it },
            ) { info ->
                info.file shouldEndWith FAKE_WORDLIST_FILE_SUFFIX
                info.file shouldStartWith info.id
            }

            withData(
                FAKE_WORDLIST_ID_FOO,
                FAKE_WORDLIST_ID_BAR,
                FAKE_WORDLIST_ID_BAZ,
                FAKE_WORDLIST_ID_QUX,
            ) { id ->
                Wordlists.getByIdOrDefault(id).file shouldBe FAKE_WORDLIST_FILE_REINHOLD
            }
        }
    })
