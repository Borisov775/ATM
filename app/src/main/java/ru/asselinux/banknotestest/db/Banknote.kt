package ru.asselinux.banknotestest.db

import androidx.room.Entity

@Entity(tableName = "banknote")
data class Banknote (
    val id: Int,
    val currency: String,
    var banknotes: String,
    val balance: Double
) {
    companion object {
        fun populateData() = listOf(
            Banknote(0, "RUB", "50, 100, 200, 500, 1000, 5000", 10000.0),
            Banknote(1, "WTF", "3, 5, 7", 10000.0),
            Banknote(2, "EUR", "5, 10, 20", 10000.0),
            Banknote(3, "USD", "1, 5, 10", 10000.0)
        )
    }
}
