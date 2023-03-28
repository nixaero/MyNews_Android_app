package mob.nereek.io.network.api

interface APIResponse<Type> {
    fun onSuccess(result: Type?)
    fun onError(t: Throwable)
}
