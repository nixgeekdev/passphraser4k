package dev.nixgeek.passphrases.wordlists

interface WordlistContext {
    fun get(info: Wordlists): Context

    fun get(id: String): Context

    fun getRandom(): Context
}
