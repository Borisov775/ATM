package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.asselinux.banknotestest.R
import ru.asselinux.banknotestest.data.Balance

class BalanceFragment : Fragment(R.layout.fragment_balance) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.showBalance).text=Balance.BALANCE.toString()
        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            findNavController().popBackStack()
        }
        view.findViewById<Button>(R.id.btnSendToMenu).setOnClickListener{
            findNavController().navigate(R.id.startFragment)
        }
    }
}