package ru.asselinux.banknotestest.data

object Balance {
    var BALANCE:Double=100000.0
    fun checkBalance():Double{
        return BALANCE
    }
    fun withdrawOperation(currencyName:String,double: Double){
        when(currencyName){
            "€"-> BALANCE-=double*73.70
            "$"-> BALANCE-=double*69.45
            "₽"-> BALANCE-=double
            "WTF"-> BALANCE-=double*1000
        }

    }
}