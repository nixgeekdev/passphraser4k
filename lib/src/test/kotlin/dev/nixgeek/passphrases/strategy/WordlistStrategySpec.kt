package dev.nixgeek.passphrases.strategy

import dev.nixgeek.passphrases.fixtures.WordlistGenerator
import dev.nixgeek.passphrases.wordlists.Wordlists
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData

class WordlistStrategySpec :
    FunSpec({
        context("load files") {
            withData(
                Wordlists.entries.map { entry -> entry.id },
            ) { id ->
                val wl = WordlistGenerator.generate(id)!!
                println("ID: ${wl["id"]}")
                println("URL: ${wl["url"]}")
                println("TYPE: ${wl["type"]}")
                println("LENGTH: ${wl["length"]}")
                println()
            }
        }
    })
