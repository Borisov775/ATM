package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_choose_currency.view.*
import kotlinx.android.synthetic.main.fragment_details.view.*
import ru.asselinux.banknotestest.R
import ru.asselinux.banknotestest.data.Banknote
import ru.asselinux.banknotestest.data.DataStorage
import ru.asselinux.banknotestest.models.DetailsViewModel

class DetailsFragment : Fragment(R.layout.fragment_details) {
    var inputPos: Int? = null
    var inputName: String = ""
    var inputImage: Int? = null

    private val banknoteDetailViewModel by viewModels<DetailsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputPos = arguments?.getInt("input_pos")
        inputName = arguments?.getString("input_name").toString()
        inputImage = arguments?.getInt("input_image")


        val versions = DataStorage.getBanknotesList()
        var currentBanknoterId: Long? = null

        val title = view.findViewById<TextView>(R.id.title)
        val currency = view.findViewById<TextView>(R.id.currency)
        val imageCurrency = view.findViewById<ImageView>(R.id.imageCurrency)
        val optionOne = view.findViewById<RadioButton>(R.id.optionOne)
        val optionTwo = view.findViewById<RadioButton>(R.id.optionTwo)
        val optionThree = view.findViewById<RadioButton>(R.id.optionThree)
        val optionFour = view.findViewById<RadioButton>(R.id.optionFour)
        val optionFive = view.findViewById<RadioButton>(R.id.optionFive)
        val optionSix = view.findViewById<RadioButton>(R.id.optionSix)
        val balance = view.findViewById<TextView>(R.id.balance)


//        findViewById<ImageView>(R.id.poster).setImageResource(android.posterAndroid)
//        findViewById<ImageView>(R.id.avatar).setImageResource(android.imageAndroid)
//        findViewById<TextView>(R.id.title).text = android.title
//        findViewById<TextView>(R.id.released_date).text = android.releaseDate
//        findViewById<TextView>(R.id.overview_text).text = android.overview


        currentBanknoterId?.let {
            title.text = versions.toString()
            currency.text = versions.toString()
            //imageCurrency.setImageResource(versions)
            balance.text = versions.toString()

        }


//        view.findViewById<ImageView>(R.id.avatar).setImageResource(android.imageAndroid)
//        view.findViewById<TextView>(R.id.title).text = android.title
//        view.findViewById<TextView>(R.id.released_date).text = android.releaseDate
//        view.findViewById<TextView>(R.id.overview_text).text = android.overview



    }
}