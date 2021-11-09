package ru.asselinux.banknotestest.repo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

class TransactionSuccessRepo(private val transactionDao: TransactionDao) {

    private val transaction_id = MutableLiveData<Long>()

    val transactionDetails = Transformations.switchMap(transaction_id) {
        transactionDao.getTransaction(it)
    }

    fun getTransactionDetails(transId: Long) {
        transaction_id.value = transId
    }

}