
import com.google.gson.annotations.SerializedName


data class Sections (

  @SerializedName("id"             ) var id             : String?               = null,
  @SerializedName("type"           ) var type           : String?               = null,
  @SerializedName("name"           ) var name           : String?               = null,
  @SerializedName("orientation"    ) var orientation    : String?               = null,
  @SerializedName("viewAllEnabled" ) var viewAllEnabled : Boolean?              = null,
  //@SerializedName("items"          ) var items          : ArrayList<String>     = arrayListOf(),
  @SerializedName("categories"     ) var categories     : ArrayList<Categories> = arrayListOf(),
  //@SerializedName("banner"         ) var banner         : String?               = null,
 // @SerializedName("action"         ) var action         : String?               = null

)