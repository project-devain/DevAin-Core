package skywolf46.devain.core.api.plugin

import org.koin.core.component.KoinComponent
import java.io.File

abstract class PluginModule(val pluginName: String) : KoinComponent {

    lateinit var dataDirectory: File
        internal set

    open fun canBeLoaded(): Boolean {
        return true
    }

    open fun onPreInitialize() {
        // Do nothing
    }

    open fun onInitialize() {
        // Do nothing
    }

    open fun onPostInitialize() {
        // Do nothing
    }

    open suspend fun getStatistics(): Map<String, List<PluginStatistics>> {
        return emptyMap()
    }

    open fun getVersion(): String {
        return "unspecified"
    }

    data class PluginStatistics(val name: String, val value: String)
}