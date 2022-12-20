package ru.asselinux.banknotestest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.asselinux.banknotestest.R
import ru.asselinux.banknotestest.data.Banknote

class BanknotesAdapter(
    private val money: List<Banknote>,
    private val listener: Transaction
) : RecyclerView.Adapter<BanknotesAdapter.DatasViewHolder>() {

    private var banknotes: List<Banknote> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatasViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency, parent, false)
        return DatasViewHolder(view)
    }

    override fun onBindViewHolder(holder: DatasViewHolder, position: Int) {
        holder.bind(banknotes[position])
    }

    override fun getItemCount(): Int = banknotes.size

    fun bindBanknotes(newBanknotes: List<Banknote>) {
        banknotes = newBanknotes
    }

    inner class DatasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val imageCurrency: ImageView = itemView.findViewById(R.id.imageCurrency)
        private val currency: TextView = itemView.findViewById(R.id.currency)

        fun bind(version: Banknote) {
            imageCurrency.setImageResource(version.imageCurrency)
            currency.text = version.currency
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = bindingAdapterPosition
            listener.passData(money[position])
        }
    }
}

interface Transaction {
    fun passData(banknote: Banknote)
    fun passValue(integer: Int)
}