package lk.fmt.findmytutor.models.preferences

import com.chibatching.kotpref.KotprefModel

object UserPreferences: KotprefModel() {
    var isLoggedIn by booleanPref(default = false)
    var name by nullableStringPref(default = null)
    var email by nullableStringPref(default = null)
    var mobile by nullableStringPref(default = null)
    var token by nullableStringPref(default = null)
}