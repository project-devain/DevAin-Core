package skywolf46.devain.configuration.adapter

import skywolf46.devain.configuration.ConfigurationMap

interface ConfigurationAdapter<REPLACE> {
    fun remapFrom(data: ConfigurationMap<*>): REPLACE

    fun remapTo(data: REPLACE): Map<String, Any>
}