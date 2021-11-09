package ru.asselinux.banknotestest.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

class BalanceRepo(private val customerDao: BanknoteDao, private val transactionDao: TransactionDao) {

    private val customerId = MutableLiveData<Long>()

    val balance = Transformations.switchMap(customerId) {
        customerDao.getBalance(it)
    }

    val listOfTransaction: LiveData<List<Transaction>?> = Transformations.switchMap(customerId) {
        transactionDao.getAllTransactions(it)
    }

    fun getBalance(customerId: Long) {
        this.customerId.value = customerId
    }
}