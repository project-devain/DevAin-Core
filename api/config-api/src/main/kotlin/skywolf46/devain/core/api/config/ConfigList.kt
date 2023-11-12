package skywolf46.devain.core.api.config

interface ConfigList<T : Any> : ConfigElement<List<ConfigElement<T>>>, MutableList<T>