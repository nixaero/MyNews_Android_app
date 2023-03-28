package mob.nereek.newsapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleModel(

    @Json(name = "source")
    var source      : SourceModel?,
    @Json(name = "author")
    var author      : String?,
    @Json(name = "title")
    var title       : String?,
    @Json(name = "description")
    var description : String?,
    @Json(name = "url")
    var url         : String?,
    @Json(name = "urlToImage")
    var urlToImage  : String?,
    @Json(name = "publishedAt")
    var publishedAt : String?,
    @Json(name = "content")
    var content     : String?

)
