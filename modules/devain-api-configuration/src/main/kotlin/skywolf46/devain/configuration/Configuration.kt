package skywolf46.devain.configuration

import java.io.DataOutput

interface Configuration<T: Any> {
    fun export(): String

    fun export(output: DataOutput)

    fun exportOrigin(): T
}