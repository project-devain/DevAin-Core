package skywolf46.devain.configuration.impl

import org.json.JSONArray
import org.json.JSONObject
import skywolf46.devain.configuration.Configuration
import skywolf46.devain.configuration.ConfigurationList
import skywolf46.devain.configuration.ConfigurationMap
import skywolf46.devain.configuration.ConfigurationProvider
import java.io.DataInput

val ConfigurationProvider.Companion.JSON: JsonProvider
    get() = JsonProvider

object JsonProvider : ConfigurationProvider {

    override fun createMap(map: Map<String, Any>?): ConfigurationMap<*> {
        return JsonMap(map)
    }

    override fun createList(list: List<Any>?): ConfigurationList<*> {
        return JsonList(list)
    }

    override fun load(stream: DataInput): Configuration<*> {
        val text = stream.readUTF().trim()
        if (text.startsWith("["))
            return JsonList(JSONArray(text));
        if (text.startsWith("{"))
            return JsonMap(JSONObject(text))
        throw IllegalStateException("Illegal JSON string")
    }

}
