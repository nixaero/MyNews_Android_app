package mob.nereek.io.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import mob.nereek.io.databinding.FragmentHomeBinding
import mob.nereek.io.tools.viewModelProvider
import mob.nereek.io.ui.MainActivity
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    private var mAdapter = HomeAdapter()
    private var country = "us"


    @Inject
    lateinit var viewModelProvider: Provider<HomeViewModel>

    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)

        (activity as MainActivity).mainComponent.inject(this)
        viewModel = this.viewModelProvider(viewModelProvider)



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.homeRecyclerView.adapter = mAdapter


        mAdapter.notifyDataSetChanged()
        mAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
        })

        swipeRefresh()
        changeCountry()
        callNewsAPI()

        return binding.root
    }

    fun swipeRefresh(){
        binding.swiperefresh.setOnRefreshListener {
            viewModel.getArticleList(country)
        }
    }
    fun changeCountry(){

        binding.changeCountry.setOnClickListener {

            if(binding.imgFr.alpha == 1.0f){
                binding.imgFr.alpha = 0.3f
                binding.imgUsa.alpha = 1f

                country = "us"
            } else{
                binding.imgUsa.alpha = 0.3f
                binding.imgFr.alpha = 1f

                country = "fr"
            }

            viewModel.getArticleList(country)

        }

    }

    fun callNewsAPI(){
        with(viewModel) {
            getArticleList(country)
            articleList.observe(viewLifecycleOwner) {
                if (it != null) {
                    mAdapter.data = it
                    binding.homeRecyclerView.adapter=mAdapter
                }
            }

            isLoading.observe(viewLifecycleOwner) {
                binding.swiperefresh.isRefreshing = it
            }

        }
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.dispose()
    }

}