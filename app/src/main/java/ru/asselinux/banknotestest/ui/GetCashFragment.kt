package ru.asselinux.banknotestest.ui

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
        val versions = DataStorage.getBanknotesList()
        adapter = BanknotesAdapter(versions, this@GetCashFragment)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        adapter.bindBanknotes(DataStorage.getBanknotesList())
        adapter.notifyDataSetChanged()
    }

    private fun shuffleBanknotes() {
        val originalData: List<Banknote> = DataStorage.getBanknotesList()
        val shuffledList: List<Banknote> = DataStorage.getBanknotesList()
        adapter.bindBanknotes(shuffledList)

        val diffCallback = BanknoteDiffUtilCallbackSolution(originalData, shuffledList)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(adapter)
    }

    override fun passData(position: Int, name: String, image: Int) {
        val text = "Выберете сумму в евро"
        val action = GetCashFragmentDirections.actionGetCashFragmentToDetailsFragment(text)
        findNavController().navigate(action)
    }
}

