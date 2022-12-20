package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.asselinux.banknotestest.R

class WithdrawOptions: Fragment(R.layout.options_money_withdraw) {
    private val args: WithdrawOptionsArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.withdrawQuote).text = args.radioOption.toString()
        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            findNavController().popBackStack()
        }
        view.findViewById<Button>(R.id.btnGetCash).setOnClickListener {
            findNavController().navigate(R.id.checkCash)
        }
    }


}