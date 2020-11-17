package com.example.jetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.jetpack.model.Persona
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_calculadora.*


/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of paramet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_fragment1_to_fragment2)
        }
        b_camara.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_fragment1_to_fragmentCamara)
        }
        b_calc.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_fragment1_to_fragmentCalculadora)
        }
    }

}