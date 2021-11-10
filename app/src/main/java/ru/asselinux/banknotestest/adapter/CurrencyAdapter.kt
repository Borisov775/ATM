package ru.asselinux.banknotestest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.asselinux.banknotestest.R
import ru.asselinux.banknotestest.data.Banknote

//class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()

class CurrencyAdapter(Context: Context,
                      private val banknote: List<Banknote>,
                      private val clickListener: (position: Int) -> Unit
) : RecyclerView.Adapter<CurrencyAdapter.ViewHolder> () {

    private val inflater: LayoutInflater = LayoutInflater.from(Context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_currency, parent, false), clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = banknote.size

    private fun getItem(position: Int) : Banknote = banknote[position]

//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class ViewHolder(
        itemView: View,
        listener: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val imageCurrency: ImageView = itemView.findViewById(R.id.imageCurrency)
        private val currency: TextView = itemView.findViewById(R.id.currency)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener(position)
                }
            }
        }

        fun bind(version: Banknote) {
            imageCurrency.setImageResource(version.imageCurrency)
            currency.text = version.currency
        }
    }

}

