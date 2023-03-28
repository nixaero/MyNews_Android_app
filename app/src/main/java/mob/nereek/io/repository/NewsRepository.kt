package mob.nereek.io.repository

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import mob.nereek.io.BuildConfig
import mob.nereek.io.network.api.APIResponse
import mob.nereek.io.network.api.APIService
import mob.nereek.newsapp.data.model.NewsModel
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private var apiService: APIService,
) {
     fun loadNews(
        compositeDisposable: CompositeDisposable,
        input: String,
        onResponse: APIResponse<NewsModel>
        ): io.reactivex.rxjava3.disposables.Disposable {
        return apiService.getNews(country = input,apiKey = BuildConfig.APINEWS_KEY)
            .subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onResponse.onSuccess(it)
            }, {
                onResponse.onError(it)
            }).also {
                compositeDisposable.add(it)
            }

    }
}
