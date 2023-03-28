package mob.nereek.io.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import mob.nereek.io.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed(3000) {
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment,)
        }

    }


}