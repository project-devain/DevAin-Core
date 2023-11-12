package skywolf46.devain.api.reflection

import arrow.core.Either
import arrow.core.Option
import java.lang.reflect.Field
import kotlin.reflect.KClass

interface ClassReflector<T : Any> {

    fun searchField(scope: ReflectionScope): List<Field>

    fun searchMethods(scope: ReflectionScope): List<ReflectionCallable<*, *>>

    fun <FIELD : Any> extract(origin: T, field: String): Option<FIELD>

    fun <FIELD : Any> extractStatic(origin: T): Option<FIELD>

    fun <RETURN : Any> call(origin: T, args: List<Any>): Option<RETURN>

    fun callEmpty(origin: T, args: List<Any>) {
        call<Any>(origin, args)
    }

    fun <RETURN : Any> callStatic(origin: T, args: List<Any>): Option<RETURN>

    fun callStaticEmpty(origin: T, args: List<Any>) {
        callStatic<Any>(origin, args)
    }

    fun parentClasses(includeInterface: Boolean): List<Class<*>>

    fun hasParentClass(clazz: Class<*>): Boolean

    fun hasParentClass(clazz: KClass<*>): Boolean {
        return hasParentClass(clazz.java)
    }

    fun create(args: List<Any>): Either<Exception, T>

    fun createWithMapping(mappings: Map<String, Any>): Either<Exception, T>
}