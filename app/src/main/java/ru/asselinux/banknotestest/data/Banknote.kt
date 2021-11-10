package ru.asselinux.banknotestest.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Banknote(
    val title: String,
    val currency: String,
    @DrawableRes val imageCurrency: Int,
    var optionOne: Int,
    var optionTwo: Int,
    var optionThree: Int,
    var optionFour: Int,
    var optionFive: Int,
    var optionSix: Int,
   // var optionSeven: Int = 0,
    val balance: Double
) : Parcelable

//{
//    companion object {
//        fun populateData() = listOf(
//            Banknote(0, "RUB", "50, 100, 200, 500, 1000, 5000", 10000.0),
//            Banknote(1, "WTF", "3, 5, 7", 10000.0),
//            Banknote(2, "EUR", "5, 10, 20", 10000.0),
//            Banknote(3, "USD", "1, 5, 10", 10000.0)
//        )
//    }
//}



