package mob.nereek.io.ui.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import mob.nereek.io.databinding.HolderHomeBinding
import mob.nereek.newsapp.data.model.ArticleModel
import kotlin.properties.Delegates


class HomeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var data: List<ArticleModel> by Delegates.observable(emptyList()) { property, oldValue, newValue ->
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderHomeBinding = HolderHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(holderHomeBinding)
    }

    private fun getItem(position: Int): ArticleModel{
        return data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HomeViewHolder).onBind(getItem(position))
    }


    private inner class HomeViewHolder(private val binding: HolderHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleModel) {


            binding.details.visibility = View.GONE

            binding.cardView.setOnClickListener {

                if(binding.details.visibility == View.GONE ) {
                    binding.photo.layoutParams.height = binding.photo.layoutParams.height + 200
                    binding.details.visibility = View.VISIBLE
                }else {
                    binding.photo.layoutParams.height = binding.photo.layoutParams.height - 200
                    binding.details.visibility = View.GONE
                }
            }

            binding.openBrowser.setOnClickListener {
                openInBrowser(data.url.toString())
            }


            binding.photo.load(data.urlToImage)
            binding.author.text = data.author
            binding.date.text = data.publishedAt
            binding.title.text = data.title
            binding.source.text = data.source?.name ?: ""
            binding.description.text = data.description

        }

        fun openInBrowser(website : String){
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website))
            var context: Context? = binding.root.context

            if (context != null) {
                context.startActivity(browserIntent)
            }
        }
    }
}