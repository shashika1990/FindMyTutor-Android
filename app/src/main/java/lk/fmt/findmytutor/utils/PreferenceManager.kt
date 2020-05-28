package lk.fmt.findmytutor.utils

import lk.fmt.findmytutor.models.preferences.UserPreferences

object PreferenceManager {

    fun clearUserPrefs() {
        UserPreferences.clear()
    }

    var isLoggedIn: Boolean
        get() {
            return UserPreferences.isLoggedIn
        }
        set(value) {
            UserPreferences.isLoggedIn = value
        }

    var name: String?
        get() {
            return UserPreferences.name
        }
        set(value) {
            UserPreferences.name = value
        }

    var email: String?
        get() {
            return UserPreferences.email
        }
        set(value) {
            UserPreferences.email = value
        }

    var mobile: String?
        get() {
            return UserPreferences.mobile
        }
        set(value) {
            UserPreferences.mobile = value
        }

    var token: String?
        get() {
            return UserPreferences.token
        }
        set(value) {
            UserPreferences.token = value
        }

    fun clearAllPrefs() {
        UserPreferences.clear()
    }

}