package nikhilbhutani.github.io.dextra.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class AppViewModelFactory @Inject constructor(
    private val viewModelMap: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = viewModelMap[modelClass] ?: viewModelMap.asIterable().firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}