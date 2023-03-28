package mob.nereek.io.di.module

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mob.nereek.io.di.ViewModelKey
import mob.nereek.io.ui.home.HomeViewModel

@Module
abstract class BinderModule {

    @Binds
    abstract fun bindContext(app: Application): Context

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

}