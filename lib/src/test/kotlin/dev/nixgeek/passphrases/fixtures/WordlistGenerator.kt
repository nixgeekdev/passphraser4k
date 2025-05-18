package dev.nixgeek.passphrases.fixtures

import dev.nixgeek.passphrases.Random
import dev.nixgeek.passphrases.wordlists.Wordlists
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.jsonObject

object WordlistGenerator {
    private val json = Json { prettyPrint = true }
    private val wlFileNames = Wordlists.entries.map { it.file }
    private val jsonCache = wlFileNames.associateWith { fileName -> loadFile(fileName) }

    @OptIn(ExperimentalSerializationApi::class)
    private fun loadFile(filename: String): JsonElement =
        json.decodeFromStream<JsonElement>(
            Random::class.java.getResourceAsStream("/$filename")
                ?: throw IllegalStateException("wordlist not found for filename: $filename"),
        )

    fun generate(id: String): JsonObject? = jsonCache["$id.json"]?.jsonObject
}
