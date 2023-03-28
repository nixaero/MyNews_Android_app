package mob.nereek.io.network.api

import io.reactivex.rxjava3.core.Observable
import mob.nereek.newsapp.data.model.ArticleModel
import mob.nereek.newsapp.data.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    fun getNews(@Query("country") country:String,@Query("apiKey") apiKey:String ) : Observable<NewsModel>

}

