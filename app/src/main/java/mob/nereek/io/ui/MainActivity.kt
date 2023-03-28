package mob.nereek.io.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import mob.nereek.io.MainApplication
import mob.nereek.io.R
import mob.nereek.io.databinding.ActivityMainBinding
import mob.nereek.io.di.component.MainComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent
    private lateinit var binding: ActivityMainBinding
    private var currentNavController: LiveData<NavController>? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        supportActionBar?.hide()

        mainComponent = (applicationContext as MainApplication).provideAppComponent().mainComponent().create()
        mainComponent.inject(this)

    }
}