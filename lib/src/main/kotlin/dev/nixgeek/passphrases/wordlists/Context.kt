package dev.nixgeek.passphrases.wordlists

sealed interface Context {
    val id: String
    val url: String
    val type: Int
    val length: Int
    val words: Map<String, String>
}
