package skywolf46.devain.configuration.impl.yaml

import org.yaml.snakeyaml.Yaml
import skywolf46.devain.configuration.ConfigurationList
import java.io.DataOutput

class YamlList(list: List<Any>? = null) : ConfigurationList<List<Any>>(list){
    override fun export(): String {
        return Yaml().dump(exportOrigin())
    }

    override fun export(output: DataOutput) {
        output.writeUTF(export())
    }

    override fun exportOrigin(): List<Any> {
        return super.asList()
    }

}