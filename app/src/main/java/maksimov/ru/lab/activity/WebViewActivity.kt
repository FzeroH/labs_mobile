package maksimov.ru.lab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatDelegate
import maksimov.ru.lab.R

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val webView: WebView = findViewById(R.id.web_view)
        webView.webViewClient = WebViewClient()
        webView.apply {
            loadUrl(URL)
        }
    }

    companion object{
        private val URL: String = "https://www.google.ru/"
    }

}