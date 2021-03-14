package com.example.foto_s05

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.imageView = findViewById(R.id.image)

        this.imageView.setOnClickListener({captureImage(it)})

    }

    fun captureImage(view: View){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent,1)
        }else{
            Toast.makeText(this, "Erro, não tem activity", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)

        }else if (resultCode == Activity.RESULT_CANCELED){
            Log.i("APP_TELAS", "Voltou: " + "Voltou pelo dispositivo")
        }

    }





}