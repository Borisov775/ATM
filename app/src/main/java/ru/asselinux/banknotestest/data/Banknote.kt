package ru.asselinux.banknotestest.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

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
    val balance: Double
) : Parcelable




