package mob.nereek.newsapp.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
data class SourceModel(

    @Json(name = "id")
    var id   : String?,
    @Json(name = "name")
    var name : String?

)