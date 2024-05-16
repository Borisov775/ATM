package ru.asselinux.banknotestest.ui

import android.app.Application
import ru.asselinux.banknotestest.data.Balance

open class MyApplication: Application() {

    companion object Balance {

        @JvmField
        var balanceData: Double = 100000.0
        fun withdrawOperation(value:Int){
            @JvmField
            balanceData-=value.toDouble()
        }
    }


}
