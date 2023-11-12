package skywolf46.devain.core.api

interface Trigger {
    companion object;

    suspend fun trigger()
}