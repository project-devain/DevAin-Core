package skywolf46.devain.core.api.config

interface ConfigManager<T : ConfigElement<*>> {
    fun createNewMap(): ConfigManager<*>

    fun createNewList(): ConfigManager<*>
}