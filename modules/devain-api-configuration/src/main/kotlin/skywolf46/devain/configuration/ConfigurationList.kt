package skywolf46.devain.configuration

import arrow.core.Option
import arrow.core.toOption


abstract class ConfigurationList<T : Any>(list: List<Any>? = null) : Configuration<T> {
    private val data = mutableListOf<Any>()

    init {
        list?.apply {
            data.addAll(this)
        }
    }

    open fun get(index: Int): Any? {
        return data[index]
    }

    open fun size(): Int {
        return data.size
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> getOption(index: Int): Option<T> {
        return (get(index) as T).toOption()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> getAs(index: Int): Option<T> {
        return (get(index) as? T).toOption()
    }

    open fun set(index: Int, value: Any) {
        data[index] = value
    }

    open fun remove(index: Int): Boolean {
        return data.remove(index)
    }

    open fun asList(): MutableList<Any> {
        return data.toMutableList()
    }
}