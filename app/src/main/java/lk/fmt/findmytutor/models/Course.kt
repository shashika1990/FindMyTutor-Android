package lk.fmt.findmytutor.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Course(
    var id: String?,
    var title: String?,
    var description: String?,
    var district: String?,
    var city: String?,
    var startDate: String?,
    var time: String?,
    var day: String?,
    var subject: String?,
    var grade: String?,
    var classType: Int,
    var classTypeClient: String?,
    var medium: Int,
    var mediumClient: String?,
    var banner: String?,
    var bannerPath: String?,
    var tutor: Tutor?
) : Parcelable {
    constructor(): this(
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        0,
        null,
        0,
        null,
        null,
        null,
        null
    )
}