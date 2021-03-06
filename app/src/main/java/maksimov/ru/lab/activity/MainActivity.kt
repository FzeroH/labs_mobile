package maksimov.ru.lab.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import maksimov.ru.lab.R

class MainActivity : AppCompatActivity() {

    private lateinit var mBtnWeb: Button
    private lateinit var mBtnGallery: Button
    private lateinit var mBtnSql: Button
    private lateinit var mBtnSensors: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        mBtnWeb = findViewById(R.id.btn_web)
        mBtnGallery = findViewById(R.id.btn_gallery)
        mBtnSql = findViewById(R.id.btn_sql)
        mBtnSensors = findViewById(R.id.btn_sensors)
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
        mBtnSensors.setOnClickListener{
            val intentSensors = Intent(this@MainActivity, SensorsActivity::class.java)
            startActivity(intentSensors)
        }
    }
}