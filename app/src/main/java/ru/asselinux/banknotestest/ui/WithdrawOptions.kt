package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.asselinux.banknotestest.R
import java.util.Currency

class WithdrawOptions: Fragment(R.layout.options_money_withdraw) {
    private val args: WithdrawOptionsArgs by navArgs()
    private var radioOption:Int=0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.radioOption.toString()
        //initialization of options
        val optionsEuro= listOf(5,10,20,50,100,200,500)
        val optionsDollar= listOf(1,2,5,10,20,50,100)
        val optionsRouble= listOf(50,100,200,500,1000,2000,5000)
        val optionsWTF= listOf(1,1,1,1,1,1,1)
        val list = mutableListOf<Int>()
        val value:String=args.radioOption.toString()+" "+args.currencyCharacter
        view.findViewById<TextView>(R.id.sum_to_withdraw).text=value
        val radio1:RadioButton=view.findViewById(R.id.radio1)
        val radio2:RadioButton=view.findViewById(R.id.radio2)
        val radio3:RadioButton=view.findViewById(R.id.radio3)
        val radio4:RadioButton=view.findViewById(R.id.radio4)
        val radio5:RadioButton=view.findViewById(R.id.radio5)
        val radio6:RadioButton=view.findViewById(R.id.radio6)
        val radio7:RadioButton=view.findViewById(R.id.radio7)


        val radioGroup: RadioGroup =view.findViewById(R.id.variety_of_us_dollar)
        val groupOfOptions= arrayOf(radio1,radio2,radio3,radio4,radio5,radio6,radio7)

        when(args.currencyCharacter){
            "€"-> groupOfOptions.forEachIndexed{index,value->

                groupOfOptions.get(index).text=optionsEuro.get(index).toString()
                list.add(index,optionsEuro.get(index))
                if(args.radioOption<optionsEuro.get(index)){
                    groupOfOptions.get(index).visibility=View.INVISIBLE
                }
            }
            "$"-> groupOfOptions.forEachIndexed{index,value->

                groupOfOptions.get(index).text=optionsDollar.get(index).toString()
                list.add(index,optionsDollar.get(index))
                if(args.radioOption<optionsDollar.get(index)){
                    groupOfOptions.get(index).visibility=View.INVISIBLE
                }
            }
            "₽"-> groupOfOptions.forEachIndexed{index,value->

                groupOfOptions.get(index).text=optionsRouble.get(index).toString()
                list.add(index,optionsRouble.get(index))
                if(args.radioOption<optionsRouble.get(index)){
                    groupOfOptions.get(index).visibility=View.INVISIBLE
                }
            }
            "WTF"-> groupOfOptions.forEachIndexed{index,value->

                groupOfOptions.get(index).text=optionsWTF.get(index).toString()
                list.add(index,optionsWTF.get(index))
                if(args.radioOption<optionsWTF.get(index)){
                    groupOfOptions.get(index).visibility=View.INVISIBLE
                }
            }

        }


        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            findNavController().popBackStack()
        }


        view.findViewById<Button>(R.id.btnGetCash).setOnClickListener {
            val selectedRadioButton:Int=radioGroup.checkedRadioButtonId
            when (selectedRadioButton) {
                R.id.radio1 -> {
                    radioOption = list.get(0)
                    Toast.makeText(requireActivity(), "Вы выбрали ${list.get(0)} ${args.currencyCharacter}", Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.radio2->
                {
                    radioOption=list.get(1)
                    Toast.makeText(requireActivity(),"Вы выбрали ${list.get(1)} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()
                }
                R.id.radio3->
                {
                    radioOption=list.get(2)
                    Toast.makeText(requireActivity(),"Вы выбрали ${list.get(2)} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()

                }
                R.id.radio4->
                {
                    radioOption=list.get(3)
                    Toast.makeText(requireActivity(),"Вы выбрали ${list.get(3)} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()
                }
                R.id.radio5->
                {
                    radioOption=list.get(4)
                    Toast.makeText(requireActivity(),"Вы выбрали ${list.get(4)} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()
                }
                R.id.radio6->
                {
                    radioOption=list.get(5)
                    Toast.makeText(requireActivity(),"Вы выбрали ${list.get(5)} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()
                }
                R.id.radio7->
                {
                    radioOption=list.get(6)
                    Toast.makeText(requireActivity(),"Вы выбрали ${list.get(6)} ${args.currencyCharacter}",
                        Toast.LENGTH_SHORT).show()
                }
            }

            var radioOptionString=radioOption.toString()+" "+args.currencyCharacter
            passValue(radioOptionString,value,args.radioOption,args.currencyCharacter)
        }
    }
    fun passValue(radioOption:String,sum:String,sum_integer:Int,currencyType:String){
        val action = WithdrawOptionsDirections.actionWithdrawOptionsToCheckCash(radioOption,sum,sum_integer,currencyType)
        findNavController().navigate(action)
    }


}


