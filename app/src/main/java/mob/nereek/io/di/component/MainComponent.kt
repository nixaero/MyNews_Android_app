package mob.nereek.io.di.component

import dagger.Subcomponent
import mob.nereek.io.di.ActivityScope
import mob.nereek.io.ui.MainActivity
import mob.nereek.io.ui.home.HomeFragment
import mob.nereek.io.ui.splash.SplashFragment


@ActivityScope
@Subcomponent
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(splashFragment: SplashFragment)
    fun inject(homeFragment: HomeFragment)

}