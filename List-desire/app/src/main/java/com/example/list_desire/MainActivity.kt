package com.example.list_desire

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.list_desire.model.Desejo
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var listDesejos: ListView
    private lateinit var btAdd: FloatingActionButton
    private lateinit var list: ArrayList<Desejo>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.list = ArrayList()
        this.listDesejos = findViewById(R.id.listDesejos)

        this.btAdd = findViewById(R.id.fabAdd)
        this.listDesejos.adapter = ArrayAdapter<Desejo>(this, android.R.layout.simple_list_item_1,this.list)

        this.listDesejos.setOnItemClickListener(C)

        this.btAdd.setOnClickListener({clickAdd(it)})
    }

    fun clickAdd(view: View) {
        val intent = Intent(this,CadastroActivity::class.java)

        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 1){
                val desejo = data?.getSerializableExtra("DESEJO") as Desejo
                (this.listDesejos.adapter as ArrayAdapter<Desejo>).add(desejo)
                Log.i("DESEJOS", this.list.toString())
            }
        }else if (resultCode == Activity.RESULT_CANCELED){
            Log.i("APP_TELAS", "Voltou: " + "Voltou pelo dispositivo")
        }
    }
}