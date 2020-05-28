package lk.fmt.findmytutor.application

import android.app.Application
import android.content.res.Resources
import lk.fmt.findmytutor.services.api.retrofit.RetrofitConfig
import lk.fmt.findmytutor.utils.FMTNetworkUtil

class FMTApp : Application() {

    companion object {
        lateinit var res: Resources
    }

    override fun onCreate() {
        super.onCreate()

        initApp()
    }

    private fun initApp() {
        FMTNetworkUtil.init(context = applicationContext)
        RetrofitConfig.init()
        res = resources
    }

}