package ru.asselinux.banknotestest.models

import androidx.lifecycle.ViewModel
import ru.asselinux.banknotestest.data.Banknote
import ru.asselinux.banknotestest.data.DataStorage

class DetailsViewModel(private val datasource: DataStorage) : ViewModel() {

    /* Queries data to returns a banknote that corresponds to an id. */
    fun getBanknoteForId(id: Long) : List<Banknote> {
        return datasource.getBanknotesList()
    }
}