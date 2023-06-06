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


class ThirdFragment : Fragment() {

    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        args?.origem?.let {
            view.findViewById<TextView>(R.id.origemThirdFragment).text = "Origem: $it"
        }

        val bundle = bundleOf("origem" to "ThirdFragment")

        val buttonThirdToFirst = view.findViewById<Button>(R.id.buttonThirdToFirst)

        buttonThirdToFirst.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment, bundle)
        }

        val buttonThirdToSecond = view.findViewById<Button>(R.id.buttonThirdToSecond)

        buttonThirdToSecond.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_secondFragment, bundle)
        }

        return view
    }
}