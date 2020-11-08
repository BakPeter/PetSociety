package com.bpapps.petsociety.viewmodel

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModel
import com.bpapps.petsociety.view.MainActivity

class SplashScreenViewModel : ViewModel() {
    fun loadData(activity: Activity?) {
        activity?.getSharedPreferences(
            MainActivity.SHARED_PREFERENCES_FILE_NAME,
            Context.MODE_PRIVATE
        )?.let { sp ->
            isRegistered = sp.getBoolean(MainActivity.PREFERENCES_IS_REGISTERED, false)
        }
    }

    var isRegistered: Boolean = false
}