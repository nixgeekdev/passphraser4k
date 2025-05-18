package dev.nixgeek.passphrases.wordlists

import dev.nixgeek.passphrases.WORDLIST_FILE_SUFFIX

sealed interface WordlistDetails {
    val id: String
    val file: String
        get() = "$id$WORDLIST_FILE_SUFFIX"
}
