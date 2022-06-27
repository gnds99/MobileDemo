import com.example.mobiledemo.data.model.request.UserLoginRequest
import com.example.mobiledemo.data.model.request.UserRequest
import com.google.gson.annotations.SerializedName

class Wrapper(@SerializedName("user") val user: UserLoginRequest){

}