package ru.asselinux.banknotestest.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.asselinux.banknotestest.R
import ru.asselinux.banknotestest.adapter.*
import ru.asselinux.banknotestest.data.Banknote
import ru.asselinux.banknotestest.data.DataStorage

class GetCashFragment : Fragment(R.layout.fragment_choose_currency), Transaction {
    private lateinit var adapter: BanknotesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler: RecyclerView = view.findViewById(R.id.banknoteList)
        val getBanknote = DataStorage.getBanknotesList()
        adapter = BanknotesAdapter(getBanknote, this@GetCashFragment)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateData() {
        adapter.bindBanknotes(DataStorage.getBanknotesList())
        adapter.notifyDataSetChanged()
    }

    private fun shuffleBanknotes() {
        val originalData: List<Banknote> = DataStorage.getBanknotesList()
        val shuffledList: List<Banknote> = DataStorage.getBanknotesList()
        adapter.bindBanknotes(shuffledList)

        val diffCallback = BanknoteDiffUtilCallback(originalData, shuffledList)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(adapter)
    }

    override fun passData(banknote: Banknote) {
        val action = GetCashFragmentDirections
            .actionGetCashFragmentToDetailsFragment(banknote)
        findNavController().navigate(action)
    }
}

