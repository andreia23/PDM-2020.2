package com.example.list_desire

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.list_desire.model.Desejo

class CadastroActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var etValor : EditText
    private lateinit var btCadastrar : Button
    private lateinit var btCancelar : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        this.etDescricao = findViewById(R.id.etDes)
        this.etValor = findViewById(R.id.etValor)
        this.btCadastrar = findViewById(R.id.btCadas)
        this.btCancelar = findViewById(R.id.btCan)
        this.btCadastrar.setOnClickListener({cadastrar(it)})
        this.btCancelar.setOnClickListener({cancelar(it)})

    }

    fun cancelar(view: View) {
        finish()
    }

    private fun cadastrar(view: View) {
        val descricao = this.etDescricao.text.toString()
        val valor = this.etValor.text.toString().toFloat()

        val desejo = Desejo(descricao,valor)
        val intent = Intent()
        intent.putExtra("DESEJO", desejo)
        setResult(Activity.RESULT_OK,intent)
        finish()

    }
}