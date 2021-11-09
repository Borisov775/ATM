package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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