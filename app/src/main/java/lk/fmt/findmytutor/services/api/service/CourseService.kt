package lk.fmt.findmytutor.services.api.service

import lk.fmt.findmytutor.services.api.responsemodels.CoursesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CourseService : SuperService {

    @GET("/api/courses")
    fun getCourses(
        @Query("\$expand") expand: String,
        @Query("\$top") top: Int,
        @Query("\$skip") skip: Int,
        @Query("\$count") count: Boolean
    ): Call<List<CoursesResponse>>
}