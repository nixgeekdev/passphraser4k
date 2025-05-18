package dev.nixgeek.passphrases.strategy.eff

import dev.nixgeek.passphrases.strategy.PassphraseStrategy
import dev.nixgeek.passphrases.wordlists.Context
import dev.nixgeek.passphrases.wordlists.DefaultContext

class EffShortPassphraseStrategy(
    override val context: DefaultContext,
) : PassphraseStrategy<Context, String> {
    companion object {
        const val WORDS_IN_PASSPHRASE = 6
    }

    override operator fun invoke(): String {
        TODO("Not yet implemented")
    }
}
