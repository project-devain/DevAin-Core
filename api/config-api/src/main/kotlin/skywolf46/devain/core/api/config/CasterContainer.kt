package skywolf46.devain.core.api.config

import arrow.core.Option
import skywolf46.devain.core.api.UnregisterTrigger

interface CasterContainer {
    fun <FROM : Any, TO : Any> registerCaster(
        cls: Class<FROM>,
        to: Class<TO>,
        caster: Caster<FROM, TO>
    ): UnregisterTrigger

    fun <FROM : Any, TO : Any> getCaster(from: Class<FROM>, to: Class<TO>): Option<Caster<FROM, TO>>
}