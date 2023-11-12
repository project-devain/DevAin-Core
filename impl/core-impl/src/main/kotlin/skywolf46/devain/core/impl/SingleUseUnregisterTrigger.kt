package skywolf46.devain.core.impl

import skywolf46.devain.core.api.UnregisterTrigger
import skywolf46.devain.core.api.exceptions.AlreadyUsedException
import java.util.concurrent.atomic.AtomicBoolean

class SingleUseUnregisterTrigger(private val unit: suspend () -> Unit) : UnregisterTrigger {
    private val used = AtomicBoolean(false)
    override suspend fun trigger() {
        if (used.compareAndSet(false, true))
            unit()
        else
            throw AlreadyUsedException()
    }
}