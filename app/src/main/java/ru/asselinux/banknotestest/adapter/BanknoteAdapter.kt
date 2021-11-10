package ru.asselinux.banknotestest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.asselinux.banknotestest.R
import ru.asselinux.banknotestest.data.Banknote

class BanknoteAdapter : RecyclerView.Adapter<DataViewHolder>() {

    private var banknotes: List<Banknote> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(banknotes[position])
    }

    override fun getItemCount(): Int = banknotes.size

    fun bindBanknotes(newBanknotes: List<Banknote>) {
        banknotes = newBanknotes
    }
}

class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val imageCurrency: ImageView = itemView.findViewById(R.id.imageCurrency)
    private val currency: TextView = itemView.findViewById(R.id.currency)

//    init {
//        itemView.setOnClickListener {
//            val position = adapterPosition
//            if (position != RecyclerView.NO_POSITION) {
//                listener(position)
//            }
//        }
//    }

    fun bind(version: Banknote) {
        imageCurrency.setImageResource(version.imageCurrency)
        currency.text = version.currency
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context
