package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.asselinux.banknotestest.R

class WithdrawOptions: Fragment(R.layout.options_money_withdraw) {
    private val args: WithdrawOptionsArgs by navArgs()
    private var radioOption:Int=0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.radioOption.toString()
        val value:String=args.radioOption.toString()+" "+args.currencyCharacter
        view.findViewById<TextView>(R.id.sum_to_withdraw).text=value
        val radioGroup: RadioGroup =view.findViewById(R.id.variety_of_us_dollar)
        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            findNavController().popBackStack()
        }


        view.findViewById<Button>(R.id.btnGetCash).setOnClickListener {
            val selectedRadioButton:Int=radioGroup.checkedRadioButtonId
            when (selectedRadioButton) {
                R.id.radio1 -> {
                    radioOption = 1
                    Toast.makeText(requireActivity(), "Вы выбрали ${1} ${args.currencyCharacter}", Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.radio2->
                {
                    radioOption=2
                    Toast.makeText(requireActivity(),"Вы выбрали ${2} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()
                }
                R.id.radio3->
                {
                    radioOption=5
                    Toast.makeText(requireActivity(),"Вы выбрали ${5} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()

                }
                R.id.radio4->
                {
                    radioOption=10
                    Toast.makeText(requireActivity(),"Вы выбрали ${10} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()
                }
                R.id.radio5->
                {
                    radioOption=20
                    Toast.makeText(requireActivity(),"Вы выбрали ${20} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()
                }
                R.id.radio6->
                {
                    radioOption=50
                    Toast.makeText(requireActivity(),"Вы выбрали ${50} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()
                }
                R.id.radio7->
                {
                    radioOption=100
                    Toast.makeText(requireActivity(),"Вы выбрали ${100} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()
                }
            }


            passValue(radioOption.toString(),value)
        }
    }
    fun passValue(radioOption:String,sum:String){
        val action = WithdrawOptionsDirections.actionWithdrawOptionsToCheckCash(radioOption,sum)
        findNavController().navigate(action)
    }


}


