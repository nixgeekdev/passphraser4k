package dev.nixgeek.passphrases.wordlists

import dev.nixgeek.passphrases.WORDLIST_ID_BEALE
import dev.nixgeek.passphrases.WORDLIST_ID_EFF_GOT
import dev.nixgeek.passphrases.WORDLIST_ID_EFF_HP
import dev.nixgeek.passphrases.WORDLIST_ID_EFF_LARGE
import dev.nixgeek.passphrases.WORDLIST_ID_EFF_SHORT
import dev.nixgeek.passphrases.WORDLIST_ID_EFF_ST
import dev.nixgeek.passphrases.WORDLIST_ID_EFF_SW
import dev.nixgeek.passphrases.WORDLIST_ID_EFF_UNIQUE_SHORT
import dev.nixgeek.passphrases.WORDLIST_ID_NL_ADJECTIVES
import dev.nixgeek.passphrases.WORDLIST_ID_NL_NOUNS
import dev.nixgeek.passphrases.WORDLIST_ID_REINHOLD

enum class Wordlists(
    override val id: String,
) : WordlistDetails {
    DICEWARE_BEALE(WORDLIST_ID_BEALE),
    DICEWARE_REINHOLD(WORDLIST_ID_REINHOLD),
    EFF_8K_GAME_OF_THRONES(WORDLIST_ID_EFF_GOT),
    EFF_8K_HARRY_POTTER(WORDLIST_ID_EFF_HP),
    EFF_8K_STARTREK(WORDLIST_ID_EFF_ST),
    EFF_8K_STARWARS(WORDLIST_ID_EFF_SW),
    EFF_GENERAL_SHORT(WORDLIST_ID_EFF_SHORT),
    EFF_LONG(WORDLIST_ID_EFF_LARGE),
    EFF_UNIQUE_PREFIX_SHORT(WORDLIST_ID_EFF_UNIQUE_SHORT),
    NATURAL_LANGUAGE_ADJECTIVES(WORDLIST_ID_NL_ADJECTIVES),
    NATURAL_LANGUAGE_NOUNS(WORDLIST_ID_NL_NOUNS),
    ;

    companion object {
        fun getByIdOrDefault(id: String): Wordlists =
            Wordlists.entries.firstOrNull { it.id == id } ?: DICEWARE_REINHOLD
    }
}
