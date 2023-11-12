package skywolf46.devain.api.reflection

interface ReflectionScope {
    fun filter(clazz: Class<*>): Boolean
}