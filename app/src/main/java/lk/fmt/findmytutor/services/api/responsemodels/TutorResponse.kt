package lk.fmt.findmytutor.services.api.responsemodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TutorResponse(
    @SerializedName("username")
    @Expose
    var username: String,
    @SerializedName("email")
    @Expose
    var email: String,
    @SerializedName("firstName")
    @Expose
    var firstName: String,
    @SerializedName("lastName")
    @Expose
    var lastName: String,
    @SerializedName("displayName")
    @Expose
    var displayName: String,
    @SerializedName("gender")
    @Expose
    var gender: String,
    @SerializedName("mobile")
    @Expose
    var mobile: String,
    @SerializedName("profileUrl")
    @Expose
    var profileUrl: String,
    @SerializedName("active")
    @Expose
    var active: Boolean,
    @SerializedName("qualifications")
    @Expose
    var qualifications: List<Qualification>
) {
    class Qualification(
        @SerializedName("type")
        @Expose
        var type: String,
        @SerializedName("area")
        @Expose
        var area: String,
        @SerializedName("university")
        @Expose
        var university: String
    )
}