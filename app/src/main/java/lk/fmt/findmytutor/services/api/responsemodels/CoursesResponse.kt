package lk.fmt.findmytutor.services.api.responsemodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("Id")
    @Expose
    var id: String?,
    @SerializedName("Title")
    @Expose
    var title: String?,
    @SerializedName("Description")
    @Expose
    var description: String?,
    @SerializedName("District")
    @Expose
    var district: String?,
    @SerializedName("City")
    @Expose
    var city: String?,
    @SerializedName("StartDate")
    @Expose
    var startDate: String?,
    @SerializedName("Time")
    @Expose
    var time: String?,
    @SerializedName("Day")
    @Expose
    var day: String?,
    @SerializedName("Subject")
    @Expose
    var subject: String?,
    @SerializedName("Grade")
    @Expose
    var grade: String?,
    @SerializedName("Active")
    @Expose
    var active: Boolean?,
    @SerializedName("ClassType")
    @Expose
    var classType: Int?,
    @SerializedName("Medium")
    @Expose
    var medium: Int?,
    @SerializedName("BannerPath")
    @Expose
    var bannerPath: String?,
    @SerializedName("CreatedDate")
    @Expose
    var createdDate: String?,
    @SerializedName("ModifiedDate")
    @Expose
    var modifiedDate: String?,
    @SerializedName("TutorEmail")
    @Expose
    var tutorEmail: String?,
    @SerializedName("TutorUsername")
    @Expose
    var tutorUsername: String?,
    @SerializedName("Tutor")
    @Expose
    var tutor: TutorResponse?
)
