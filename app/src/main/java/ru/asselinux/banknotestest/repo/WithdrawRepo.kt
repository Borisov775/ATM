package ru.asselinux.banknotestest.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.asselinux.banknotestest.db.Banknote
import java.util.*

class WithdrawRepo(private val customerDao: BanknoteDao, private val transactionDao: TransactionDao) {

    suspend fun withdraw(customerId: Long, amount: Double): Banknote? {
        return withContext(Dispatchers.IO) {
            customerDao.canWithdraw(customerId, amount)
        }
    }

//    suspend fun debitCustomer(customer: Banknote, amount: Double) {
//        withContext(Dispatchers.IO) {
//            customer.balance = customer.balance - amount
//            customerDao.updateCustomer(customer)
//        }
//    }

    suspend fun saveDebit(customer: Banknote, amount: Double): Long {
        return withContext(Dispatchers.IO) {
            val date = Calendar.getInstance().time
            val balance = customer.balance
            val transaction = Transaction(0, amount, balance)
            transactionDao.saveTransaction(transaction)
        }
    }

}