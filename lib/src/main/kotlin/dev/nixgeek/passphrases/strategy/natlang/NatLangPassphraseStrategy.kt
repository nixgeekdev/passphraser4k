package dev.nixgeek.passphrases.strategy.natlang

import dev.nixgeek.passphrases.strategy.PassphraseStrategy
import dev.nixgeek.passphrases.wordlists.Context

sealed interface NatLangPassphraseStrategy : PassphraseStrategy<Context, String> {
    val adjectives: Context
    val nouns: Context

    override val context: Context
        get() = nouns
}
