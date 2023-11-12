package skywolf46.devain.core.api.config

import java.io.DataInput

interface ConfigManager<T : ConfigElement<*>> {
    fun createNewMap(container: CasterContainer): ConfigMap

    fun <T : Any> createNewList(container: CasterContainer): ConfigList<T>

    fun readMap(stream: DataInput, container: CasterContainer): ConfigMap

    fun <T : Any> readList(stream: DataInput, container: CasterContainer): ConfigList<T>
}