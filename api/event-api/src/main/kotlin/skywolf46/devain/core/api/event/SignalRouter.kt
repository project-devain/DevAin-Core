package skywolf46.devain.core.api.event

import skywolf46.devain.core.api.UnregisterTrigger

interface SignalRouter<T : Any> {
    companion object;

    fun <DATA : T> routeSignal(signal: DATA): DATA

    fun <DATA : T> addRoute(clazz: Class<DATA>, listener: (DATA) -> Unit): UnregisterTrigger
}