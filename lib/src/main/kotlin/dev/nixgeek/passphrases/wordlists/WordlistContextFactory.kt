package dev.nixgeek.passphrases.wordlists

import dev.nixgeek.passphrases.Random
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.util.concurrent.ConcurrentHashMap

object WordlistContextFactory : WordlistContext {
    private val json = Json { ignoreUnknownKeys = true }
    private val wordlistCache = ConcurrentHashMap<String, Context>()

    override fun get(info: Wordlists): DefaultContext = get(info.id)

    override fun get(id: String): DefaultContext =
        wordlistCache.computeIfAbsent(id) { loadContext(id) } as DefaultContext

    override fun getRandom(): DefaultContext =
        Random.secureRandom.nextInt(Wordlists.entries.size).let {
            get(Wordlists.entries[it])
        }

    fun availableContextIds(): List<String> = Wordlists.entries.map { it.id }

    @OptIn(ExperimentalSerializationApi::class)
    private fun loadContext(id: String): DefaultContext =
        json.decodeFromStream<DefaultContext>(
            javaClass.getResourceAsStream(Wordlists.getByIdOrDefault(id).file)
                ?: throw IllegalStateException("context not found for id: $id"),
        )
}
