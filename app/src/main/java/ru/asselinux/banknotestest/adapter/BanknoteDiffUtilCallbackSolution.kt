package ru.asselinux.banknotestest.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.asselinux.banknotestest.data.Banknote

class BanknoteDiffUtilCallbackSolution(
    private val oldList: List<Banknote>,
    private val newList: List<Banknote>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.currency == newItem.currency
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size
}