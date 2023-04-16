package skywolf46.devain.configuration.impl.json

import org.json.JSONArray
import skywolf46.devain.configuration.ConfigurationList
import java.io.DataOutput

class JsonList(list: List<Any>? = null) : ConfigurationList<JSONArray>(list) {

    constructor(jsonArray: JSONArray?) : this(jsonArray?.toList())

    override fun export(): String {
        return exportOrigin().toString()
    }

    override fun export(output: DataOutput) {
        output.writeUTF(export())
    }

    override fun exportOrigin(): JSONArray {
        return JSONArray(super.asList())
    }
}