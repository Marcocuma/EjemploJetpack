package com.example.jetpack

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_camara.*


class FragmentCamara : Fragment() {
    val respuestaImagen = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camara, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY))
            b_tomarFoto.setOnClickListener {
                capturarFoto()
            }
        else {
            println("No tiene camara")
        }
    }
    fun capturarFoto(){
        println("Hace el evento")
        val permissionCheck =
            context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.CAMERA) }
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivityForResult(callCameraIntent, respuestaImagen)
            }
        } else {
            ActivityCompat.requestPermissions(
                (context as Activity)!!,
                arrayOf(Manifest.permission.CAMERA),
                respuestaImagen
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && data != null){
            imageView.setImageBitmap(data.extras?.get("data") as Bitmap)
        } else {
            Toast.makeText(this.context, "No se reconoce la respuesta", Toast.LENGTH_SHORT).show()
        }
    }
}