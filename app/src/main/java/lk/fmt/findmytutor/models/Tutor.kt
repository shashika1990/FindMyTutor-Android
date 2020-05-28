package lk.fmt.findmytutor.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Tutor(
    var username: String?,
    var email: String?,
    var fullName: String?,
    var displayName: String?,
    var gender: String?,
    var mobile: String?,
    var profileUrl: String?,
    var active: Boolean,
    var qualifications: ArrayList<Qualification>?
) : Parcelable {
    constructor() : this(
        username = null,
        email = null,
        fullName = null,
        displayName = null,
        gender = null,
        mobile = null,
        profileUrl = null,
        active = false,
        qualifications = null
    )
}