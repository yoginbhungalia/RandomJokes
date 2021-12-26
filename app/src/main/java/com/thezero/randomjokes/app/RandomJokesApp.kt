package com.thezero.randomjokes.app

import android.app.Application
import com.thezero.randomjokes.core.preferences.SharedPref

class RandomJokesApp: Application() {
    companion object {
        var localPreference: SharedPref? = null
    }

    override fun onCreate() {
        super.onCreate()

        localPreference = SharedPref(applicationContext)
    }
}