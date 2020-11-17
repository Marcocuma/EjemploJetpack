package com.example.jetpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_calculadora.*


class FragmentCalculadora : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculadora, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b_calcular.setOnClickListener {
            if (editTextNumber1.text.isNotEmpty() && editTextNumber2.text.isNotEmpty())
                when(grupo1.checkedRadioButtonId){
                    radioButtonDivision.id -> {
                        if (editTextNumber2.text.toString().equals("0")){
                            Toast.makeText(context, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show()
                        }else {
                            val resultado =
                                Integer.parseInt((editTextNumber1.text.toString())) / Integer.parseInt(
                                    (editTextNumber2.text.toString())
                                )
                            val bundle = Bundle()
                            bundle.putInt("result", resultado)
                            Navigation.findNavController(it).navigate(
                                R.id.action_fragmentCalculadora_to_fragmentDivision,
                                bundle
                            )
                        }
                    }
                    radioButtonResta.id -> {
                        val resultado = Integer.parseInt((editTextNumber1.text.toString()))-Integer.parseInt((editTextNumber2.text.toString()))
                        val bundle = Bundle()
                        bundle.putInt("result", resultado)
                        Navigation.findNavController(it).navigate(R.id.action_fragmentCalculadora_to_fragmentResta,bundle)
                    }
                    radioButtonSuma.id -> {
                        val resultado = Integer.parseInt((editTextNumber1.text.toString()))+Integer.parseInt((editTextNumber2.text.toString()))
                        val bundle = Bundle()
                        bundle.putInt("result", resultado)
                        Navigation.findNavController(it).navigate(R.id.action_fragmentCalculadora_to_fragmentSuma,bundle)
                    }
                }
        }
    }

}