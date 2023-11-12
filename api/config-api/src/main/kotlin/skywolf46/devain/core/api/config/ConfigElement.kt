package skywolf46.devain.core.api.config

import arrow.core.Either
import java.io.DataOutput

interface ConfigElement<T : Any> {
    fun get(): T

    fun <TARGET : Any> cast(clazz: Class<TARGET>): Either<Throwable, TARGET>

    fun export(output: DataOutput)

    fun classDeclaration() : Class<T>
}

fun <T : Any> ConfigElement<*>.forceCast(clazz: Class<T>): T {
    return cast(clazz).fold({ throw it }, { it })
}

inline fun <reified T : Any> ConfigElement<*>.cast(): Either<Throwable, T> {
    return cast(T::class.java)
}

inline fun <reified T : Any> ConfigElement<*>.forceCast(): T {
    return forceCast(T::class.java)
}

