package com.example.websiteviwerhomework7

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class WebActivity : AppCompatActivity() {

    private lateinit var mySiteView : WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        mySiteView = findViewById<WebView>(R.id.mySiteView).apply {
            settings.javaScriptEnabled = true
            webViewClient = MyWebViewClient()
            webChromeClient = MyChromeWebViewClient()
            loadUrl(context.getString(R.string.mainUrl))
        }

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            if(mySiteView.canGoBack()){
                mySiteView.goBack()
            }
        }

        val fwdButton = findViewById<Button>(R.id.forwardButton)
        fwdButton.setOnClickListener {
            if(mySiteView.canGoForward()){
                mySiteView.goForward()
            }
        }
    }

}

private class MyWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return false
    }
}

private class MyChromeWebViewClient : WebChromeClient() {
}