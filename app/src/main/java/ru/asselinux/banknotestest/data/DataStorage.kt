package ru.asselinux.banknotestest.data

import ru.asselinux.banknotestest.R

object DataStorage {

    fun getBanknotesList(): List<Banknote> {
        return listOf(
            Banknote(
                "Выберите сумму в евро",
                "EUR",
                R.drawable.euro,
                5,
                10,
                20,
                50,
                100,
                200,
                10000.0,
            ),

            Banknote(
                "Выберите сумму в долларах",
                "USD",
                R.drawable.dollar,
                1,
                5,
                10,
                20,
                50,
                100,
                10000.0,
            ),

            Banknote(
                "Выберите сумму в рублях",
                "RUB",
                R.drawable.ruble,
                50,
                100,
                200,
                500,
                1000,
                5000,
                100000.0,
            ),

            Banknote(
                "Выберите сумму в wtf",
                "WTF",
                R.drawable.money,
                3,
                5,
                7,
                13,
                17,
                23,
                1000.0,
            )
        )
    }
}