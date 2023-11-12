package skywolf46.devain.core.impl

import skywolf46.devain.core.api.Trigger
import skywolf46.devain.core.api.exceptions.AlreadyUsedException
import java.util.concurrent.atomic.AtomicBoolean

class SingleUseTrigger(private val unit: suspend () -> Unit) : Trigger {
    private val used = AtomicBoolean(false)
    override suspend fun trigger() {
        if (used.compareAndSet(false, true))
            unit()
        else
            throw AlreadyUsedException()
    }
}