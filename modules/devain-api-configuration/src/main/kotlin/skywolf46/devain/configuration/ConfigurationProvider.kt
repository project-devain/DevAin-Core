package skywolf46.devain.configuration

import java.io.DataInput

interface ConfigurationProvider {
    companion object

    fun createMap(map: Map<String, Any>? = null): ConfigurationMap<*>

    fun createList(list: List<Any>? = null): ConfigurationList<*>

    fun load(stream: DataInput): Configuration<*>
}