package mob.nereek.io.di.component

import mob.nereek.io.di.AppScope
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import mob.nereek.io.MainApplication
import mob.nereek.io.di.module.BinderModule
import mob.nereek.io.di.module.NetworkModule
import javax.inject.Singleton


@AppScope
@Singleton
@Component(modules = [
    NetworkModule::class,
    BinderModule::class,
    SubComponentsModule::class
])
interface AppComponent {

    fun inject(app: MainApplication)

    fun mainComponent(): MainComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}