package com.thezero.randomjokes.core.preferences

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {

    companion object {
        private const val RANDOM_JOKES_SHARED_PREFERENCES = "RandomJokesSharedPreferences"

        private const val PREFERENCE_NO_OF_TIMES_APP_OPENS = "NoOfTimesAppOpens"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(RANDOM_JOKES_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    var noOfTimesAppOpens: Int
        get() = sharedPreferences.getInt(PREFERENCE_NO_OF_TIMES_APP_OPENS, 0)
        set(value) = sharedPreferences.edit().putInt(PREFERENCE_NO_OF_TIMES_APP_OPENS, value).apply()

}