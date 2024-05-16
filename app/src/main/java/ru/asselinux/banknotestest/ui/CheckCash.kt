package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.asselinux.banknotestest.R
import ru.asselinux.banknotestest.data.Balance
import ru.asselinux.banknotestest.data.Balance.BALANCE
import ru.asselinux.banknotestest.data.Balance.withdrawOperation

class CheckCash: Fragment(R.layout.check_cash){
    private val args: CheckCashArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Balance.withdrawOperation(args.currencyName,args.sum.toDouble())
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.amount_in_cash).text=args.cashType
        view.findViewById<TextView>(R.id.typeX).text=args.cash
        view.findViewById<Button>(R.id.btnGetBalance_1).setOnClickListener {
            findNavController().navigate(R.id.balanceFragment)
        }

    }
}