package skywolf46.devain.core.impl

import skywolf46.devain.core.api.Trigger

class RunnableTrigger(private val unit: suspend () -> Unit) : Trigger {
    override suspend fun trigger() {
        unit()
    }
}