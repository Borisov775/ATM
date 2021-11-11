package ru.asselinux.banknotestest.ui.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import ru.asselinux.banknotestest.R

class ProgressDialog : DialogFragment(R.layout.progress_dialog) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val TAG = "Dialog"
    }
}