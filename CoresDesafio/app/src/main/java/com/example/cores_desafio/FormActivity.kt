package com.example.cores_desafio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import com.example.cores_desafio.model.Cor

class FormActivity : AppCompatActivity() {
    private lateinit var nomeCor: EditText
    private lateinit var corRed: SeekBar
    private lateinit var corGreen: SeekBar
    private lateinit var corBlue: SeekBar
    private lateinit var btCor: Button
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.nomeCor = findViewById(R.id.etCor)
        this.corRed = findViewById(R.id.seekBarRed)
        this.corGreen = findViewById(R.id.seekBarGreen)
        this.corBlue = findViewById(R.id.seekBarBlue)
        this.btCor = findViewById(R.id.btCor)
        this.btSalvar = findViewById(R.id.btSalvar)
        this.btCancelar = findViewById(R.id.btCancelar)

        this.btSalvar.setOnClickListener({salvar(it)})
        this.btCancelar.setOnClickListener({cancelar(it)})


    }

    private fun salvar(view: View) {
        val nome = this.nomeCor.text.toString()
        val codigo = 1 // IMPLEMENTAR O CODIGO

        val cor = if (intent.hasExtra("COR")){
            val c = intent.getSerializableExtra("COR") as Cor
            c.nome = nome
            c.codigo = codigo
            c
        }else{
            Cor(nome,codigo)
        }

        val intent = Intent()
        intent.putExtra("COR", cor)
        setResult(Activity.RESULT_OK,intent)
        finish()

    }

    private fun cancelar(view: View){
        finish()
    }
}