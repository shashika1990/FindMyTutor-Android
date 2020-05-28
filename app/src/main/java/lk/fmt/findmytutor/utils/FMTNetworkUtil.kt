package lk.fmt.findmytutor.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build

object FMTNetworkUtil {
    private lateinit var cm: ConnectivityManager

    fun init(context: Context) {
        cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    fun isInternetConnectivityActive(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network: Network? = cm.activeNetwork
            if (network != null)
                return hasActiveInternetConnectivity(network)
            return false
        } else {
            for (network in cm.allNetworks) {
                if (network != null)
                    return hasActiveInternetConnectivity(network)
                return false
            }
        }

        return false
    }

    private fun hasActiveInternetConnectivity(network: Network): Boolean {
        return cm.getNetworkCapabilities(network)?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
    }

}