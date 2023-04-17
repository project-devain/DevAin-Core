package skywolf46.devain.configuration.impl.yaml

import org.yaml.snakeyaml.Yaml
import skywolf46.devain.configuration.ConfigurationMap
import java.io.DataOutput

class YamlMap(map: Map<String, Any>?) : ConfigurationMap<Map<String, Any>>(map){
    override fun export(): String {
        return Yaml().dump(super.asMap())
    }

    override fun export(output: DataOutput) {
        output.writeUTF(export())
    }

    override fun exportOrigin(): Map<String, Any> {
        return super.asMap()
    }

}