package lk.fmt.findmytutor.services.api.service

import lk.fmt.findmytutor.dto.UserForSignIn
import lk.fmt.findmytutor.services.api.responsemodels.SignInResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService : SuperService {
    @POST("/api/users/authenticate")
    fun signIn(@Body userForSignIn: UserForSignIn): Call<SignInResponse>

    @POST("")
    fun signUp(): Call<SignInResponse>
}