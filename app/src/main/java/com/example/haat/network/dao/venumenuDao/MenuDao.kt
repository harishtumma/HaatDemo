
import com.google.gson.annotations.SerializedName


data class MenuDao (

  @SerializedName("sections" ) var sections : ArrayList<Sections> = arrayListOf()

)