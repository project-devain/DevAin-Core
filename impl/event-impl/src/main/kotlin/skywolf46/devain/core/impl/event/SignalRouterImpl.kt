package skywolf46.devain.core.impl.event

import skywolf46.devain.core.api.UnregisterTrigger
import skywolf46.devain.core.api.event.SignalRouter
import skywolf46.devain.core.platform.from
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

class SignalRouterImpl<T : Any> : SignalRouter<T> {
    private val routeMap = mutableMapOf<Class<*>, MutableList<(Any) -> Unit>>()

    private val signalIoLock = ReentrantReadWriteLock()

    override fun <DATA : T> routeSignal(signal: DATA): DATA {
        signalIoLock.read {
            routeMap[signal::class.java]?.forEach {
                it(signal)
            }
        }
        return signal
    }

    override fun <DATA : T> addRoute(clazz: Class<DATA>, listener: (DATA) -> Unit): UnregisterTrigger {
        signalIoLock.write {
            routeMap.getOrPut(clazz) { mutableListOf() }.add(listener as (Any) -> Unit)
        }
        return UnregisterTrigger.from {
            removeRoute(clazz, listener)
        }
    }

    @Deprecated("Internal use recommended - Use UnregisterTrigger instead")
    fun <DATA : T> removeRoute(clazz: Class<DATA>, listener: (DATA) -> Unit) {
        signalIoLock.write {
            routeMap[clazz]?.remove(listener)
        }
    }
}