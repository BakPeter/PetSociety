package com.bpapps.petsociety.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bpapps.petsociety.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setLayoutToRTL()
    }

    private fun setLayoutToRTL() {
        val configuration = resources.configuration
        if (configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL) {
            window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL;
        }
    }

    companion object {
        const val SHARED_PREFERENCES_FILE_NAME: String =
            "com.bpapps.petsociety.PET_SOCIETY_SHARED_PREFERENCES"
        const val PREFERENCES_IS_REGISTERED: String =
            "com.bpapps.petsociety.PREFERENCES_IS_REGISTERED"
    }
}