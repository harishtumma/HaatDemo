
import com.google.gson.annotations.SerializedName


data class Image (

  @SerializedName("id"             ) var id             : Int?    = null,
  @SerializedName("priority"       ) var priority       : Int?    = null,
  @SerializedName("serverImageUrl" ) var serverImageUrl : String? = null,
  @SerializedName("smallImageUrl"  ) var smallImageUrl  : String? = null,
  @SerializedName("blurhash"       ) var blurhash       : String? = null,
  @SerializedName("group"          ) var group          : String? = null

)