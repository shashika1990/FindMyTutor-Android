package lk.fmt.findmytutor.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Qualification(
    var organization: String?,
    var designation: String?,
    var duration: String?
) : Parcelable {
    constructor() : this(
        organization = null,
        designation = null,
        duration = null
    )
}