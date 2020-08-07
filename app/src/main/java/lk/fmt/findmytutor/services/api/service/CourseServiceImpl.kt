package lk.fmt.findmytutor.services.api.service

import android.util.Log
import lk.fmt.findmytutor.R
import lk.fmt.findmytutor.application.FMTApp
import lk.fmt.findmytutor.listeners.APIServiceListener
import lk.fmt.findmytutor.services.api.responsemodels.CoursesResponse
import lk.fmt.findmytutor.services.api.retrofit.APIService
import lk.fmt.findmytutor.utils.FMTNetworkUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseServiceImpl(private val listener: APIServiceListener) {

    private val TAG = this.javaClass.simpleName

    private var request: CourseService = APIService.getService(APIService.Type.COURSE) as CourseService

    fun getCourses(count: Int, pageNo: Int) {
        if (!FMTNetworkUtil.isInternetConnectivityActive()) {
            listener.onError(FMTApp.res.getString(R.string.no_active_connection))
            return
        }

        request.getCourses("tutor", count, pageNo * count, true).enqueue(object : Callback<List<CoursesResponse>>{
            override fun onResponse(
                call: Call<List<CoursesResponse>>,
                response: Response<List<CoursesResponse>>
            ) {
                if (response.isSuccessful) {
                    listener.onSuccess(response.body())
                } else {
                    Log.d(TAG, "Error fetching courses.")
                }
            }

            override fun onFailure(call: Call<List<CoursesResponse>>, t: Throwable) {
                Log.d(TAG, t.message)
                listener.onError(FMTApp.res.getString(R.string.error))
            }
        })
    }

}