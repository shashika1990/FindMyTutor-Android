package lk.fmt.findmytutor.services.api.service

import lk.fmt.findmytutor.R
import lk.fmt.findmytutor.application.FMTApp
import lk.fmt.findmytutor.listeners.APIServiceListener
import lk.fmt.findmytutor.services.api.responsemodels.TutorResponse
import lk.fmt.findmytutor.services.api.retrofit.APIService
import lk.fmt.findmytutor.utils.FMTNetworkUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TutorServiceImpl(private val listener: APIServiceListener) {

    private var request: TutorService = APIService.getService(APIService.Type.TUTOR) as TutorService

    private fun getTutor(tutorId: String) {
        if (!FMTNetworkUtil.isInternetConnectivityActive()) {
            listener.onError(FMTApp.res.getString(R.string.no_active_connection))
            return
        }

        request.getTutor(tutorId).enqueue(object : Callback<TutorResponse>{
            override fun onResponse(call: Call<TutorResponse>, response: Response<TutorResponse>) {
                if (response.isSuccessful) {
                    listener.onSuccess(response.body())
                } else {
                    // TODO:
                }
            }

            override fun onFailure(call: Call<TutorResponse>, t: Throwable) {
                listener.onError(FMTApp.res.getString(R.string.error))
            }
        })
    }


}