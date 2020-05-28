package lk.fmt.findmytutor.services.api.service

import lk.fmt.findmytutor.R
import lk.fmt.findmytutor.application.FMTApp
import lk.fmt.findmytutor.dto.UserForSignIn
import lk.fmt.findmytutor.services.api.responsemodels.SignInResponse
import lk.fmt.findmytutor.services.api.retrofit.APIService
import lk.fmt.findmytutor.listeners.APIServiceListener
import lk.fmt.findmytutor.utils.FMTNetworkUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserServiceImpl(private val listener: APIServiceListener) {

    private var request: UserService = APIService.getService(APIService.Type.USER) as UserService

    fun signIn(userForSignIn: UserForSignIn) {
        if (!FMTNetworkUtil.isInternetConnectivityActive()) {
            listener.onError(FMTApp.res.getString(R.string.no_active_connection))
            return
        }

        request.signIn(userForSignIn).enqueue(object : Callback<SignInResponse> {
            override fun onResponse(
                call: Call<SignInResponse>,
                response: Response<SignInResponse>
            ) {
                if (response.isSuccessful) {
                    listener.onSuccess(response.body())
                } else {
                    // TODO:
                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                listener.onError(FMTApp.res.getString(R.string.error))
            }

        })

    }

}