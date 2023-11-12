package skywolf46.devain.core.api.config

interface ConfigElementCaster {
    fun remap(element: ConfigElement<*>): ConfigElement<*>
}