package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.asselinux.banknotestest.R
import ru.asselinux.banknotestest.adapter.Transaction
import ru.asselinux.banknotestest.data.Banknote
import ru.asselinux.banknotestest.ui.dialog.ProgressDialog

class DetailsFragment : Fragment(R.layout.fragment_details),Transaction {
    var radioOption:Int=0
    var currencyCharacter:String=""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title: TextView = view.findViewById(R.id.title)

        val radioGroup:RadioGroup=view.findViewById(R.id.radioGroup_1)
        val args: DetailsFragmentArgs by navArgs()

        title.text = args.cash.title
        when(args.cash.currency){
            "EUR"-> currencyCharacter="€"
            "USD"->currencyCharacter="$"
            "RUB"->currencyCharacter="₽"
            "WTF"->currencyCharacter="WTF"
        }




        view.findViewById<TextView>(R.id.title).text = args.cash.title
        view.findViewById<RadioButton>(R.id.radio_1).text = args.cash.optionOne.toString()
        view.findViewById<RadioButton>(R.id.radio_2).text = args.cash.optionTwo.toString()
        view.findViewById<RadioButton>(R.id.radio_3).text = args.cash.optionThree.toString()
        view.findViewById<RadioButton>(R.id.radio_4).text = args.cash.optionFour.toString()
        view.findViewById<RadioButton>(R.id.radio_5).text = args.cash.optionFive.toString()
        view.findViewById<RadioButton>(R.id.radio_6).text = args.cash.optionSix.toString()
        view.findViewById<TextView>(R.id.balance).text = args.cash.balance.toString()



        view.findViewById<Button>(R.id.btnGetCash).setOnClickListener {
            val selectedRadioButton:Int=radioGroup.checkedRadioButtonId
            when (selectedRadioButton) {
                R.id.radio_1 -> {
                    radioOption = args.cash.optionOne
                    Toast.makeText(requireActivity(), "Вы выбрали ${radioOption} ${args.cash.title.substring(16)}", Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.radio_2->
                     {
                        radioOption=args.cash.optionTwo
                        Toast.makeText(requireActivity(),"Вы выбрали ${radioOption} ${args.cash.title.substring(16)}",Toast.LENGTH_SHORT).show()
                    }
                R.id.radio_3->
                    {
                        radioOption=args.cash.optionThree
                        Toast.makeText(requireActivity(),"Вы выбрали ${radioOption} ${args.cash.title.substring(16)}",Toast.LENGTH_SHORT).show()

                    }
                R.id.radio_4->
                     {
                        radioOption=args.cash.optionFour
                         Toast.makeText(requireActivity(),"Вы выбрали ${radioOption} ${args.cash.title.substring(16)}",Toast.LENGTH_SHORT).show()
                    }
                R.id.radio_5->
                     {
                        radioOption=args.cash.optionFive
                         Toast.makeText(requireActivity(),"Вы выбрали ${radioOption} ${args.cash.title.substring(16)}",Toast.LENGTH_SHORT).show()
                    }
                R.id.radio_6->
                    {
                        radioOption=args.cash.optionSix
                        Toast.makeText(requireActivity(),"Вы выбрали ${radioOption} ${args.cash.title.substring(16)}",Toast.LENGTH_SHORT).show()
                    }
            }
            onRadioButtonClicked(radioGroup)
            passValue(radioOption,currencyCharacter)
        }

        view.findViewById<Button>(R.id.btnCancel).setOnClickListener {
            findNavController().popBackStack()
        }
    }
     fun passValue(integer:Int,string: String) {
        val action = DetailsFragmentDirections.
            fromDetailsToWithdrawOptions(integer,string)
        findNavController().navigate(action)
    }

    override fun passData(banknote: Banknote) {
        TODO("Not yet implemented")
    }

    override fun passValue(integer: Int) {
        TODO("Not yet implemented")
    }

    private fun openProgressDialog() {
        ProgressDialog().show(
            childFragmentManager, ProgressDialog.TAG
        )
    }



    fun onRadioButtonClicked(view: View){
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked
            // Check which radio button was clicked
            when (view.id) {
                R.id.radio_1 ->
                    if (checked) {
                        radioOption=5
                        Toast.makeText(requireActivity(),"Selected option = 5",Toast.LENGTH_SHORT).show()
                    }
                R.id.radio_2->
                    if (checked) {
                        radioOption=10
                        Toast.makeText(requireActivity(),"Selected option = 5",Toast.LENGTH_SHORT).show()
                    }
                R.id.radio_3->
                    if (checked) {
                        radioOption=20
                        Toast.makeText(requireActivity(),"Selected option = 5",Toast.LENGTH_SHORT).show()

                    }
                R.id.radio_4->
                    if (checked) {
                        radioOption=50
                    }
                R.id.radio_5->
                    if (checked) {
                        radioOption=100
                    }
                R.id.radio_6->
                    if (checked) {
                        radioOption=200
                    }
            }
        }

    }




}


