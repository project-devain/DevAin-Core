package skywolf46.devain.core.platform

import skywolf46.devain.core.api.Trigger
import skywolf46.devain.core.api.UnregisterTrigger
import skywolf46.devain.core.impl.RunnableTrigger
import skywolf46.devain.core.impl.SingleUseTrigger
import skywolf46.devain.core.impl.SingleUseUnregisterTrigger

fun Trigger.Companion.from(singleUse: Boolean = false, runnable: suspend () -> Unit): Trigger {
    return if (singleUse) {
        SingleUseTrigger(runnable)
    } else {
        RunnableTrigger(runnable)
    }
}

fun Trigger.Companion.fromRunnable(singleUse: Boolean = false, runnable: Runnable): Trigger {
    return from(singleUse) {
        runnable.run()
    }
}

fun UnregisterTrigger.Companion.from(runnable: suspend () -> Unit): UnregisterTrigger {
    return SingleUseUnregisterTrigger(runnable)
}

fun UnregisterTrigger.Companion.fromRunnable(runnable: Runnable): UnregisterTrigger {
    return from {
        runnable.run()
    }
}