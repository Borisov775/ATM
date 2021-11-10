package ru.asselinux.banknotestest.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import ru.asselinux.banknotestest.R

class DetailsFragment : Fragment(R.layout.fragment_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title: TextView = view.findViewById(R.id.title)
        val args: DetailsFragmentArgs by navArgs()
        val text = args.cash
        title.text = text

//        inputPos = arguments?.getInt("input_pos")
//        inputName = arguments?.getString("input_name").toString()
//        inputImage = arguments?.getInt("input_image")

        // Receive the arguments in a variable
 //       val banknoteDetails = args.toBundle()

        view.findViewById<TextView>(R.id.title).text.toString()
        view.findViewById<TextView>(R.id.currency).text.toString()
        view.findViewById<TextView>(R.id.optionOne).text
        view.findViewById<TextView>(R.id.optionTwo).text
        view.findViewById<TextView>(R.id.optionThree).text
        view.findViewById<TextView>(R.id.optionFour).text
        view.findViewById<TextView>(R.id.optionFive).text
        view.findViewById<TextView>(R.id.optionSix).text
        view.findViewById<TextView>(R.id.balance).text

//        view.findViewById<TextView>(R.id.title).text = banknoteDetails.toString()
//        view.findViewById<TextView>(R.id.currency).text = banknoteDetails.toString()
//        view.findViewById<TextView>(R.id.optionOne).text = banknoteDetails.toString()
//        view.findViewById<TextView>(R.id.optionTwo).text = banknoteDetails.toString()
//        view.findViewById<TextView>(R.id.optionThree).text = banknoteDetails.toString()
//        view.findViewById<TextView>(R.id.optionFour).text = banknoteDetails.toString()
//        view.findViewById<TextView>(R.id.optionFive).text = banknoteDetails.toString()
//        view.findViewById<TextView>(R.id.optionSix).text = banknoteDetails.toString()
//        view.findViewById<TextView>(R.id.balance).text = banknoteDetails.toString()

//        findViewById<ImageView>(R.id.poster).setImageResource(android.posterAndroid)
//        findViewById<ImageView>(R.id.avatar).setImageResource(android.imageAndroid)
//        findViewById<TextView>(R.id.title).text = android.title
//        findViewById<TextView>(R.id.released_date).text = android.releaseDate
//        findViewById<TextView>(R.id.overview_text).text = android.overview
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}
