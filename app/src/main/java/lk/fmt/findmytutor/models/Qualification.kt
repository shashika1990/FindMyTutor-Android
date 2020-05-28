package lk.fmt.findmytutor.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Qualification(
    var username: String?,
    var email: String?,
    var firstName: String?,
    var lastName: String?,
    var displayName: String?,
    var gender: String?,
    var mobile: String?,
    var profileUrl: String?,
    var active: Boolean?,
    var qualifications: List<Qualification>?
) : Parcelable {
    constructor() : this(
        username = null,
        email = null,
        firstName = null,
        lastName = null,
        displayName = null,
        gender = null,
        mobile = null,
        profileUrl = null,
        active = false,
        qualifications = null
    )
}