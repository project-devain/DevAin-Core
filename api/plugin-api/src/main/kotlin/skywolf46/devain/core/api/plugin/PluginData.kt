package skywolf46.devain.core.api.plugin

import arrow.core.Option
import java.io.File

class PluginData(val pluginName: String, val version: String, val mainClass: String, val jarFile: Option<File>, val dependencies : Option<List<String>>, val extraMetadata : Map<String, Any>) {
    companion object {
        operator fun invoke() {

        }
    }
}