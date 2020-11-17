package com.example.jetpack

import android.Manifest
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_2.*


class Fragment2 : Fragment() {
    val respuestaPermisos = 1
    var loadingFinished = true
    var redirect = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ajustesVisorWeb = webView.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        editTextUrl.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER){
                cargarWeb(editTextUrl.text.toString())
                return@OnKeyListener true
            }
            false
        })
        webView.setWebViewClient(object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                loadingFinished = false
                //SHOW LOADING IF IT ISNT ALREADY VISIBLE
            }
            override fun onPageFinished(view: WebView, url: String) {
                editTextUrl.text = Editable.Factory.getInstance().newEditable(webView.url)
            }
        })
        imageButton.setOnClickListener {
            if(webView.canGoBack())
                webView.goBack()
        }
        imageButton2.setOnClickListener {
            if(webView.canGoForward())
                webView.goForward()
        }
        cargarWeb(editTextUrl.text.toString())
    }
    fun cargarWeb(url: String){
        println("Entra en el evento cargar web")
        webView.loadUrl(url)
    }
}