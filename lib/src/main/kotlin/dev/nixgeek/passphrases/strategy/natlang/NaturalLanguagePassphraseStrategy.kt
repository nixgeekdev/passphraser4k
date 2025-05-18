package dev.nixgeek.passphrases.strategy.natlang

import dev.nixgeek.passphrases.wordlists.DefaultContext

/**
 * To create a password, roll four dice and select the corresponding word from the `adjectives`
 * list. Roll five dice and select the corresponding word from the `nouns` list. Repeat, depending
 * on whether you want a two, four, or six word password. A four-word password provides 46.5 bits
 * of entropy. For example, your password could be: `soapy weapons brisk blade`
 */
class NaturalLanguagePassphraseStrategy(
    override val adjectives: DefaultContext,
    override val nouns: DefaultContext,
) : NatLangPassphraseStrategy {
    companion object {
        const val ADJECTIVES_IN_PASSPHRASE = 3
        const val NOUNS_IN_PASSPHRASE = 3
    }

    override operator fun invoke(): String {
        TODO("Not yet implemented")
    }
}
