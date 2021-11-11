package ru.asselinux.banknotestest.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import ru.asselinux.banknotestest.R

class ProgressDialog : DialogFragment(R.layout.progress_dialog) {

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.progress_dialog, container)
//    }

    companion object {
        const val TAG = "Dialog"
    }
}