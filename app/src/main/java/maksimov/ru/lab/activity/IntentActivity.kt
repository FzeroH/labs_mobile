package maksimov.ru.lab.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import maksimov.ru.lab.R
import java.io.InputStream

class IntentActivity : AppCompatActivity() {

    private lateinit var mBtnLoadPhoto: Button
    private lateinit var mImageView: ImageView
    private var pickerPhoto: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        mImageView = findViewById(R.id.image_view)

        mBtnLoadPhoto = findViewById(R.id.btn_load_photo)
        mBtnLoadPhoto.setOnClickListener{
            loadPhoto()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == pickerPhoto){
            if(resultCode == RESULT_OK){
                try {
                    setPhoto(data = data)

                } catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
    }

    private fun setPhoto(data: Intent?){
        val imageUri: Uri = data?.data!!
        val imageStream: InputStream = contentResolver.openInputStream(imageUri)!!
        val selectedImage: Bitmap = BitmapFactory.decodeStream(imageStream)
        mImageView.setImageBitmap(selectedImage)

    }

    private fun loadPhoto() {
        val pickPhoto = Intent(Intent.ACTION_PICK)
        pickPhoto.type = "image/*"
        startActivityForResult(pickPhoto,pickerPhoto)
    }

}