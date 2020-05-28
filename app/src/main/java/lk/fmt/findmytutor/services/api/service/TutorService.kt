package lk.fmt.findmytutor.services.api.service

import lk.fmt.findmytutor.services.api.responsemodels.TutorResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TutorService : SuperService {

    @GET("/api/Tutors/{id}")
    fun getTutor(@Path("id") tutorId: String): Call<TutorResponse>
}