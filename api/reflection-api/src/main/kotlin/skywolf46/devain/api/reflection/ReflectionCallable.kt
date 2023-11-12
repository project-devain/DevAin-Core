package skywolf46.devain.api.reflection

import arrow.core.Either
import arrow.core.Option

interface ReflectionCallable<T : Any, RETURN : Any> {
    fun callArgs(origin: Option<T>, args: List<Any?>): Option<RETURN>

    fun callArgsWithMappings(origin: Option<T>, mappings: Map<String, Any?>): Either<Throwable, RETURN>

    fun call(origin: Option<T>) = callArgs(origin, emptyList())

    fun callWithMappings(origin: Option<T>) = callArgsWithMappings(origin, emptyMap())
}