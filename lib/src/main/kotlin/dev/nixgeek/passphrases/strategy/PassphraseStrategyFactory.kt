package dev.nixgeek.passphrases.strategy

import dev.nixgeek.passphrases.WORDLIST_ID_NL_NOUNS
import dev.nixgeek.passphrases.strategy.diceware.DicewarePassphraseStrategy
import dev.nixgeek.passphrases.strategy.eff.EffPassphraseStrategy
import dev.nixgeek.passphrases.strategy.eff.EffShortPassphraseStrategy
import dev.nixgeek.passphrases.strategy.eff8k.FandomPassphraseStrategy
import dev.nixgeek.passphrases.strategy.natlang.NaturalLanguagePassphraseStrategy
import dev.nixgeek.passphrases.wordlists.Context
import dev.nixgeek.passphrases.wordlists.DefaultContext
import dev.nixgeek.passphrases.wordlists.WordlistContextFactory
import dev.nixgeek.passphrases.wordlists.Wordlists

/**
 * Static Passphrase Factory Object
 */
object PassphraseStrategyFactory {
    fun get(id: String): PassphraseStrategy<Context, String> = get(WordlistContextFactory.get(id))

    fun get(context: DefaultContext): PassphraseStrategy<Context, String> =
        when (Wordlists.getByIdOrDefault(context.id)) {
            Wordlists.DICEWARE_BEALE,
            Wordlists.DICEWARE_REINHOLD,
            -> {
                DicewarePassphraseStrategy(context)
            }

            Wordlists.EFF_8K_GAME_OF_THRONES,
            Wordlists.EFF_8K_HARRY_POTTER,
            Wordlists.EFF_8K_STARTREK,
            Wordlists.EFF_8K_STARWARS,
            -> {
                FandomPassphraseStrategy(context)
            }

            Wordlists.EFF_GENERAL_SHORT,
            Wordlists.EFF_UNIQUE_PREFIX_SHORT,
            -> {
                EffShortPassphraseStrategy(context)
            }

            Wordlists.EFF_LONG -> {
                EffPassphraseStrategy(context)
            }

            Wordlists.NATURAL_LANGUAGE_NOUNS,
            Wordlists.NATURAL_LANGUAGE_ADJECTIVES,
            -> {
                if (context.id == WORDLIST_ID_NL_NOUNS) {
                    NaturalLanguagePassphraseStrategy(
                        nouns = context,
                        adjectives = WordlistContextFactory.get(Wordlists.NATURAL_LANGUAGE_ADJECTIVES),
                    )
                } else {
                    NaturalLanguagePassphraseStrategy(
                        adjectives = context,
                        nouns = WordlistContextFactory.get(Wordlists.NATURAL_LANGUAGE_NOUNS),
                    )
                }
            }
        }
}
