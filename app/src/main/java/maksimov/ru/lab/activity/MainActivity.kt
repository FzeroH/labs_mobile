package maksimov.ru.lab.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import maksimov.ru.lab.R

class MainActivity : AppCompatActivity() {

    private lateinit var mBtnWeb: Button
    private lateinit var mBtnGallery: Button
    private lateinit var mBtnSql: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnWeb = findViewById(R.id.btn_web)
        mBtnGallery = findViewById(R.id.btn_gallery)
        mBtnSql = findViewById(R.id.btn_sql)
    }

    override fun onStart() {
        super.onStart()

        mBtnWeb.setOnClickListener{
            val intentWeb = Intent(this@MainActivity, WebViewActivity::class.java)
            startActivity(intentWeb)
        }
        mBtnGallery.setOnClickListener{
            val intentGallery = Intent(this@MainActivity, IntentActivity::class.java)
            startActivity(intentGallery)
        }
        mBtnSql.setOnClickListener{
            val intentSQL = Intent(this@MainActivity, SQLiteActivity::class.java)
            startActivity(intentSQL)
        }
    }
}