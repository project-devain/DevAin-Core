package skywolf46.devain.configuration.impl.json

import org.json.JSONObject
import skywolf46.devain.configuration.ConfigurationMap
import java.io.DataOutput

class JsonMap(map: Map<String, Any>? = null) : ConfigurationMap<JSONObject>(map) {

    constructor(jsonObject: JSONObject) : this(jsonObject.toMap())

    override fun export(): String {
        return exportOrigin().toString()
    }

    override fun export(output: DataOutput) {
        output.writeUTF(export())
    }

    override fun exportOrigin(): JSONObject {
        return JSONObject(super.asMap())
    }

}