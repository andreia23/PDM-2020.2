package com.example.cores_desafio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cores_desafio.model.Cor

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

    }

    private fun cadastrar(view: View) {

        val desejo = Cor("Test",1)
        val intent = Intent()
        intent.putExtra("DESEJO", desejo)
        setResult(Activity.RESULT_OK,intent)
        finish()

    }
}