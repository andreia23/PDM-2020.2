package com.example.cores_desafio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.example.cores_desafio.dao.CorDAO
import com.example.cores_desafio.model.CadastroCor
import com.example.cores_desafio.model.Cor
import com.example.cores_desafio.model.AdapterCor
import com.google.android.material.floatingactionbutton.FloatingActionButton

const val ADD = 1
const val EDIT = 2

class MainActivity : AppCompatActivity() {

    private lateinit var listCores: ListView
    private lateinit var btAdd: FloatingActionButton
    private lateinit var cadastroCor: CadastroCor
    private lateinit var daoCor: CorDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.cadastroCor = CadastroCor()

        this.daoCor = CorDAO(this)

        this.listCores = findViewById(R.id.listCores)
        this.listCores.adapter = AdapterCor(cadastroCor, this)
        this.listCores.setOnItemClickListener(ClickEditar())
        this.listCores.setOnItemLongClickListener(ClickRemover())

        this.btAdd = findViewById(R.id.fabAdd)
        this.btAdd.setOnClickListener({ clickAdd(it) })
    }

    fun clickAdd(view: View) {
        val intent = Intent(this, FormActivity::class.java)
        startActivityForResult(intent, ADD)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == ADD) {
                val cor = data?.getSerializableExtra("COR") as Cor
                (this.listCores.adapter as AdapterCor).addCor(cor)
                (this.listCores.adapter as AdapterCor).notifyDataSetChanged()
                Toast.makeText(this, "Cor salva com sucesso!", Toast.LENGTH_SHORT).show()

            } else if (requestCode == EDIT) {
                val cor = data?.getSerializableExtra("COR") as Cor
                this.daoCor.update(cor)
                Log.i("BANCO_LOG ATUALIZAR", this.daoCor.select().toString())
                for (c in this.cadastroCor.get()) { //ver aqui
                    if (c.id == cor.id) {
                        c.nome = cor.nome
                        c.codigo = cor.codigo
                        (this.listCores.adapter as AdapterCor).notifyDataSetChanged()
                        break
                    }
                }
            }

        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "Não foi possível salvar a cor, tente novamente.", Toast.LENGTH_SHORT).show()
        }
    }

    inner class ClickEditar : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val cor = this@MainActivity.listCores.adapter.getItem(position) as Cor
            val intent = Intent(this@MainActivity, FormActivity::class.java)
            intent.putExtra("COR", cor)
            startActivityForResult(intent, EDIT)
        }
    }

    inner class ClickRemover : AdapterView.OnItemLongClickListener {
        override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
            val cor = this@MainActivity.listCores.adapter.getItem(position) as Cor
            this@MainActivity.daoCor.delete(cor.codigo)
            Log.i("DELETE", this@MainActivity.daoCor.select().toString())
            (this@MainActivity.listCores.adapter as AdapterCor).removerCor(position)
            (this@MainActivity.listCores.adapter as AdapterCor).notifyDataSetChanged()
            return true
        }
    }


}