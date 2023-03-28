package mob.nereek.newsapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsModel(

    @Json(name = "status")
    var status       : String?,
    @Json(name = "totalResults")
    var totalResults : Int?,
    @Json(name = "articles")
    var articles     : List<ArticleModel>

)
