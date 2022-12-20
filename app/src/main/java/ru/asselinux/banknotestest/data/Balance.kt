package ru.asselinux.banknotestest.data

object Balance {
    var BALANCE:Double=100000.0
    fun checkBalance():Double{
        return BALANCE
    }
    fun withdrawOperation(double: Double){
        BALANCE-=double
    }
}