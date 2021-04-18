package com.example.cores_desafio.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.cores_desafio.R

class AdapterCor(var cadastro: CadastroCor, var context: Context) : BaseAdapter() {

    fun addCor(cor: Cor) {
        this.cadastro.add(cor)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val cor = this.cadastro.get(position)
        val linha: View

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            linha = inflater.inflate(R.layout.list_layout, null)
        } else {
            linha = convertView
        }

        val image = linha.findViewById<ImageView>(R.id.imgCor)
        val nomeCor = linha.findViewById<TextView>(R.id.nomeCor)
        val codigoCor = linha.findViewById<TextView>(R.id.codCor)

        image.setImageResource(R.drawable.ic_baseline_palette_24)
        image.setColorFilter(cor.codigo)
        nomeCor.text = cor.nome
        val codHex = String.format("#%06X", (0xFFFFFF and cor.codigo))
        codigoCor.text = codHex

        return linha

    }

    fun removerCor(position: Int) {
        this.cadastro.remover(position)
    }

    override fun getCount(): Int {
        return this.cadastro.count()
    }

    override fun getItem(position: Int): Any {
        return this.cadastro.get(position)
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

}