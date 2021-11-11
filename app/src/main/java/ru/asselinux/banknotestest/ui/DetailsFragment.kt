package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.asselinux.banknotestest.R
import ru.asselinux.banknotestest.ui.dialog.ProgressDialog

class DetailsFragment : Fragment(R.layout.fragment_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title: TextView = view.findViewById(R.id.title)
        val args: DetailsFragmentArgs by navArgs()
        title.text = args.cash.title

        view.findViewById<TextView>(R.id.title).text = args.cash.title
        view.findViewById<TextView>(R.id.optionOne).text = args.cash.optionOne.toString()
        view.findViewById<TextView>(R.id.optionTwo).text = args.cash.optionTwo.toString()
        view.findViewById<TextView>(R.id.optionThree).text = args.cash.optionThree.toString()
        view.findViewById<TextView>(R.id.optionFour).text = args.cash.optionFour.toString()
        view.findViewById<TextView>(R.id.optionFive).text = args.cash.optionFive.toString()
        view.findViewById<TextView>(R.id.optionSix).text = args.cash.optionSix.toString()
        view.findViewById<TextView>(R.id.balance).text = args.cash.balance.toString()

        view.findViewById<Button>(R.id.btnGetCash).setOnClickListener {
            openProgressDialog()
        }

        view.findViewById<Button>(R.id.btnCancel).setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun openProgressDialog() {
        ProgressDialog().show(
            childFragmentManager, ProgressDialog.TAG
        )
    }
}
