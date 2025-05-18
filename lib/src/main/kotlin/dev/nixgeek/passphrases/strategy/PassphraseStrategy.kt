package dev.nixgeek.passphrases.strategy

import dev.nixgeek.passphrases.wordlists.Context

interface PassphraseStrategy<C : Context, out O> {
    val context: C

    operator fun invoke(): O
}
