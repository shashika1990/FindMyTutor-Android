package lk.fmt.findmytutor.configurations

import lk.fmt.findmytutor.helpers.API

object AppDefaults {

    // Change the app environment here
    private val CURRENT_ENV = AppEnv.DEVELOPMENT

    fun getBaseUrl(): String {
        return when (CURRENT_ENV) {
            AppEnv.DEVELOPMENT -> {
                API.baseUrlDevelopment
            }
            AppEnv.STAGING -> {
                API.baseUrlStaging
            }
            AppEnv.PRODUCTION -> {
                API.baseUrlProduction
            }
        }
    }

}