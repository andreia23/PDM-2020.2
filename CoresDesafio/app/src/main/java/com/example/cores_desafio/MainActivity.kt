package com.example.cores_desafio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.cores_desafio.model.Cor
import com.google.android.material.floatingactionbutton.FloatingActionButton

const val ADD = 1
const val EDIT = 2
class MainActivity : AppCompatActivity() {

    private lateinit var listCores: ListView
    private lateinit var btAdd: FloatingActionButton
    private lateinit var list: ArrayList<Cor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.list = ArrayList()
        this.listCores = findViewById(R.id.listCores)

        this.btAdd = findViewById(R.id.fabAdd)
        this.listCores.adapter = ArrayAdapter<Cor>(this, android.R.layout.simple_list_item_1,this.list)

//        this.listDesejos.setOnItemLongClickListener(ClickRemove())

        this.btAdd.setOnClickListener({clickAdd(it)})
    }

    // LEMBRAR DE DÁ PUSH NO PROJETO DE RENAM AMANHÃ

    fun clickAdd(view: View) {
        val intent = Intent(this,FormActivity::class.java)
        startActivityForResult(intent, ADD)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == ADD){
                val cor = data?.getSerializableExtra("COR") as Cor
                (this.listCores.adapter as ArrayAdapter<Cor>).add(cor)
                Toast.makeText(this, "Cor salva com sucesso!", Toast.LENGTH_SHORT).show()

            }else if (requestCode == EDIT){
                val cor = data?.getSerializableExtra("COR") as Cor
                for (c in this.list){
                    if (c.id == cor.id){
                        c.nome = cor.nome
                        c.codigo = cor.codigo
                        (this.listCores.adapter as ArrayAdapter<Cor>).notifyDataSetChanged()
                        break
                    }
                }
            }

        }else if (resultCode == Activity.RESULT_CANCELED){
            Toast.makeText(this, "Não foi possível salvar a cor, tente novamente.", Toast.LENGTH_SHORT).show()
        }
    }
}