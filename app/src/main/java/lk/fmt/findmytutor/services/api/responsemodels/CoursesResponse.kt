package lk.fmt.findmytutor.services.api.responsemodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("id")
    @Expose
    var id: String,
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("description")
    @Expose
    var description: String,
    @SerializedName("district")
    @Expose
    var district: String,
    @SerializedName("city")
    @Expose
    var city: String,
    @SerializedName("startDate")
    @Expose
    var startDate: String,
    @SerializedName("time")
    @Expose
    var time: String,
    @SerializedName("day")
    @Expose
    var day: String,
    @SerializedName("subject")
    @Expose
    var subject: String,
    @SerializedName("grade")
    @Expose
    var grade: String,
    @SerializedName("active")
    @Expose
    var active: Boolean,
    @SerializedName("classType")
    @Expose
    var classType: Int,
    @SerializedName("medium")
    @Expose
    var medium: Int,
    @SerializedName("banner")
    @Expose
    var banner: Any,
    @SerializedName("bannerPath")
    @Expose
    var bannerPath: String,
    @SerializedName("createdDate")
    @Expose
    var createdDate: String,
    @SerializedName("modifiedDate")
    @Expose
    var modifiedDate: String,
    @SerializedName("tutorEmail")
    @Expose
    var tutorEmail: String,
    @SerializedName("tutorUsername")
    @Expose
    var tutorUsername: String,
    @SerializedName("tutor")
    @Expose
    var tutor: TutorResponse
)
