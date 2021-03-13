package com.example.exercicio_semana03

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.exercicio_semana03.model.Pessoa

class MainActivity : AppCompatActivity() {
    private lateinit var btVai: Button
    private lateinit var nome: EditText
    private lateinit var ano: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("APP_TELAS", "Main: onCreate")

        this.nome = findViewById(R.id.nome)
        this.ano = findViewById(R.id.ano)
        this.btVai = findViewById(R.id.btMainVai)
        this.btVai.setOnClickListener({ clickBotao(it) })
    }

    fun clickBotao(view: View){
        val intent = Intent(this, OutraActivity::class.java)
        val ano: Int = this.ano.text.toString().toInt();
        val nome: String = this.nome.text.toString();
        val pessoa: Pessoa = Pessoa(nome, ano)
        intent.putExtra("PESSOA", pessoa)
        //startActivity(intent)
        startActivityForResult(intent, 1)
    }

    // é automaticamente executado quando realizada chamada forResult
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 1){
                val msg = data?.getStringExtra("MSG_VOLTA")
                Log.i("APP_TELAS", msg.toString())
            }
        }else if (resultCode == Activity.RESULT_CANCELED){
            Log.i("APP_TELAS", "Voltou: " + "Voltou pelo dispositivo")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_TELAS", "Main: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_TELAS", "Main: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_TELAS", "Main: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_TELAS", "Main: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("APP_TELAS", "Main: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_TELAS", "Main: onDestroy")
    }
}