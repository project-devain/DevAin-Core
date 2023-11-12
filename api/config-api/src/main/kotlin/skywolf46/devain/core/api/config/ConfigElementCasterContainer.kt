package skywolf46.devain.core.api.config

import arrow.core.Option
import skywolf46.devain.core.api.UnregisterTrigger

interface ConfigElementCasterContainer {
    fun registerCaster(caster: ConfigElementCaster) : UnregisterTrigger

    fun getCaster(element: ConfigElement<*>) : Option<ConfigElementCaster>

}