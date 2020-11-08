package com.bpapps.petsociety.view.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.bpapps.petsociety.R
import java.lang.IllegalStateException

class InfoDialog(private val title: String, private val message: String? = null) :
    DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        activity?.let {
            val builder = AlertDialog.Builder(requireContext())

            message?.let {
                builder.setMessage(message)
            }

            return builder.setTitle(title)
                .setCancelable(false)
                .setPositiveButton(R.string.dialog_i_read_msg) { dialog, _ ->
                    dialog.dismiss()
                }
                .create()

        } ?: throw IllegalStateException("Activity can't be null")
    }
}