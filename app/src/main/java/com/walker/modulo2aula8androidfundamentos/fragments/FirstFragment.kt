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


class FirstFragment : Fragment() {

    private val args: FirstFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)

        args?.origem?.let {
            view.findViewById<TextView>(R.id.origemFirstFragment).text = "Origem: $it"
        }

        val bundle = bundleOf("origem" to "FirstFragment")

        val buttonFirstToSecond = view.findViewById<Button>(R.id.buttonFirstToSecond)

        buttonFirstToSecond.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }

        val buttonFirstToThird = view.findViewById<Button>(R.id.buttonFirstToThird)

        buttonFirstToThird.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment, bundle)
        }

        return view
    }
}