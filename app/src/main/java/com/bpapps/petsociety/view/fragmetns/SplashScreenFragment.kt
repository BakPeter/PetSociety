package com.bpapps.petsociety.view.fragmetns

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bpapps.petsociety.R
import com.bpapps.petsociety.view.MainActivity
import com.bpapps.petsociety.view.dialogs.InfoDialog
import com.bpapps.petsociety.viewmodel.SplashScreenViewModel

class SplashScreenFragment : Fragment() {

    private val viewModel by viewModels<SplashScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        viewModel.loadData(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onResume() {
        super.onResume()

        Handler(Looper.getMainLooper()).postDelayed(
            {
                Toast.makeText(
                    requireContext(),
                    "isRegistered = ${viewModel.isRegistered}",
                    Toast.LENGTH_SHORT
                ).show()
            },
            resources.getInteger(R.integer.splash_screen_number_of_milliseconds_shower).toLong()
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.splash_screen_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val resources = resources

        return when (item.itemId) {
            R.id.menu_item_screen_remarks -> {
                InfoDialog(
                    resources.getString(R.string.dialog_remark_title),
                    resources.getString(R.string.splash_screen_remarks)
                ).show(parentFragmentManager, null)
                true
            }

            R.id.menu_item_dev_info -> {
                InfoDialog(
                    resources.getString(R.string.dialog_info_title),
                    resources.getString(R.string.splash_screen_info)
                ).show(parentFragmentManager, null)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}