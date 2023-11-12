package skywolf46.devain.core.api.config

import arrow.core.Either

interface Caster<FROM: Any, TO: Any> {
    fun remap(element: ConfigElement<FROM>): Either<Throwable, TO>
}