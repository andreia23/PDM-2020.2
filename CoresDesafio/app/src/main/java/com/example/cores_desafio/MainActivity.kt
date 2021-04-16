package com.example.cores_desafio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.cores_desafio.model.Cor
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var listDesejos: ListView
    private lateinit var btAdd: FloatingActionButton
    private lateinit var list: ArrayList<Cor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.list = ArrayList()
        this.listDesejos = findViewById(R.id.listCores)

        this.btAdd = findViewById(R.id.fabAdd)
        this.listDesejos.adapter = ArrayAdapter<Cor>(this, android.R.layout.simple_list_item_1,this.list)

//        this.listDesejos.setOnItemLongClickListener(ClickRemove())

        this.btAdd.setOnClickListener({clickAdd(it)})
    }

    // LEMBRAR DE DÁ PUSH NO PROJETO DE RENAM AMANHÃ

    fun clickAdd(view: View) {
        val intent = Intent(this,FormActivity::class.java)

        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 1){
                val desejo = data?.getSerializableExtra("DESEJO") as Cor
                (this.listDesejos.adapter as ArrayAdapter<Cor>).add(desejo)
                Log.i("Cores", this.list.toString())
            }

        }else if (resultCode == Activity.RESULT_CANCELED){
            Log.i("APP_TELAS", "Voltou: " + "Voltou pelo dispositivo")
        }
    }
}