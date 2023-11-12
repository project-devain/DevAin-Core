package skywolf46.devain.core.api.config

import arrow.core.Either
import java.io.DataOutput

interface ConfigElement<T : Any> {
    fun get(): T

    fun cast(clazz: Class<*>): Either<Throwable, T>

    fun forceCast(clazz: Class<*>): T

    fun export(): DataOutput

}

inline fun <reified T : Any> ConfigElement<T>.cast(): Either<Throwable, T> {
    return cast(T::class.java)
}

inline fun <reified T : Any> ConfigElement<T>.forceCast(): T {
    return forceCast(T::class.java)
}

