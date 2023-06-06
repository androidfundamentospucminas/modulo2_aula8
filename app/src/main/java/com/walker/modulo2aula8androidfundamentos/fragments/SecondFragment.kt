package com.walker.modulo2aula8androidfundamentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.walker.modulo2aula8androidfundamentos.R


class SecondFragment : Fragment() {

    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        args?.origem?.let {
            view.findViewById<TextView>(R.id.origemSecondFragment).text = "Origem: $it"
        }

        val bundle = bundleOf("origem" to "SecondFragment")

        val buttonSecondToFirst = view.findViewById<Button>(R.id.buttonSecondToFirst)

        buttonSecondToFirst.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment, bundle)
        }

        val buttonSecondToThird = view.findViewById<Button>(R.id.buttonSecondToThird)

        buttonSecondToThird.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }

        return view
    }
}