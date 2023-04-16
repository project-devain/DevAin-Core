package skywolf46.devain.configuration.service

import skywolf46.devain.configuration.ConfigurationProvider

interface ConfigService {
    fun registerProvider(name: String, provider: ConfigurationProvider): Boolean

    fun <T: Any> findAdapter(adapter: Class<T>)
}