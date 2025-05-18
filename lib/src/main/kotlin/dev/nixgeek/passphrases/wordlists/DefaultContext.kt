package dev.nixgeek.passphrases.wordlists

import dev.nixgeek.passphrases.WORDLIST_SERIAL_NAME
import dev.nixgeek.passphrases.rollDices
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DefaultContext(
    override val id: String,
    override val url: String,
    override val type: Int,
    override val length: Int,
    @SerialName(WORDLIST_SERIAL_NAME)
    override val words: Map<String, String>,
) : Context {
    fun get(key: String): String? = words[key]

    fun getRandom(): String? = get(rollDices(type = type, howMany = length))
}
