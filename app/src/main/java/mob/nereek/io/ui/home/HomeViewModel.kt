package mob.nereek.io.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import mob.nereek.io.network.api.APIResponse
import mob.nereek.io.repository.NewsRepository
import mob.nereek.newsapp.data.model.ArticleModel
import mob.nereek.newsapp.data.model.NewsModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    val articleList = MutableLiveData<List<ArticleModel>?>()
    val isLoading = MutableLiveData(false)


    private val compositeDisposable = CompositeDisposable()

     fun getArticleList(country: String) {
        setLoading(true)
        newsRepository.loadNews(
            compositeDisposable,
            country,
            object : APIResponse<NewsModel> {
                override fun onSuccess(result: NewsModel?) {
                    setLoading(false)
                    articleList.value = result?.articles
                }

                override fun onError(t: Throwable) {
                    setLoading(false)
                    t.printStackTrace()
                }
            })
    }

    private fun setLoading(b: Boolean) {
        isLoading.value = b
    }


    fun dispose() {
        if (compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}