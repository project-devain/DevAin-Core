package skywolf46.devain.configuration

import arrow.core.Option
import arrow.core.toOption

abstract class ConfigurationMap<T : Any>(map: Map<String, Any>?) : Configuration<T> {
    private val data = mutableMapOf<String, Any>()

    init {
        map?.apply {
            data.putAll(this)
        }
    }

    fun get(key: String): Any? {
        return data[key]
    }

    @Suppress("UNCHECKED_CAST")
    fun <V : Any> getOption(key: String): Option<V> {
        return (get(key) as V).toOption()
    }

    @Suppress("UNCHECKED_CAST")
    fun <V : Any> getAs(key: String): Option<V> {
        return (get(key) as? V).toOption()
    }


    fun set(key: String, value: Any): ConfigurationMap<T> {
        data[key] = value
        return this
    }

    fun <T : Any> setAndGet(key: String, value: T): T {
        set(key, value)
        return value
    }

    fun remove(key: String): Boolean {
        return data.remove(key) != null
    }

    fun has(key: String): Boolean {
        return data.containsKey(key)
    }

    fun asMap(): Map<String, Any> {
        return data.toMap()
    }

    fun getKeys(): List<String> {
        return data.keys.toList()
    }

    fun getKeysRecursive(): List<String> {
        return getKeyRecursive("")
    }

    private fun getKeyRecursive(prefix: String): List<String> {
        return data.entries.map {
            if (it.value is ConfigurationMap<*>) (it.value as ConfigurationMap<*>).getKeyRecursive("${prefix}.${it.key}") else listOf(
                "${prefix}.${it.key}"
            )
        }.flatten()
    }
}