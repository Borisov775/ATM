package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.asselinux.banknotestest.R

class StartFragment : Fragment(R.layout.fragment_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnGetCash).setOnClickListener {
            findNavController().navigate(R.id.action_get_cash_fragment)
        }

        view.findViewById<Button>(R.id.btnGetBalance).setOnClickListener {
            findNavController().navigate(R.id.action_get_balance)
        }
    }
}