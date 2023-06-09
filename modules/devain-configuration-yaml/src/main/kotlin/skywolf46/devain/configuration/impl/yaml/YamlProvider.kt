package skywolf46.devain.configuration.impl.yaml

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import org.yaml.snakeyaml.Yaml
import skywolf46.devain.configuration.Configuration
import skywolf46.devain.configuration.ConfigurationList
import skywolf46.devain.configuration.ConfigurationMap
import skywolf46.devain.configuration.ConfigurationProvider
import java.io.DataInput

val ConfigurationProvider.Companion.YAML: YamlProvider
    get() = YamlProvider

object YamlProvider : ConfigurationProvider {
    override fun createMap(map: Map<String, Any>?): ConfigurationMap<*> {
        return YamlMap(map)
    }

    override fun createList(list: List<Any>?): ConfigurationList<*> {
        return YamlList(list)
    }

    override fun load(stream: DataInput): Either<Throwable, Configuration<*>> {
        val loaded = Yaml().load<Any>(stream.readUTF())
        if (loaded is List<*>)
            return YamlList(loaded as List<Any>?).right()
        if (loaded is Map<*, *>)
            return YamlMap(loaded as Map<String, Any>?).right()
        return IllegalStateException("Unknown object parsed while loading yaml string").left()
    }
}