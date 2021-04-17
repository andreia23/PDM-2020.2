package com.example.cores_desafio.model

class CadastroCor {
    private lateinit var list: ArrayList<Cor>

    init {
        this.list = arrayListOf()
    }

    fun add(cor: Cor) {
        this.list.add(cor)
    }

    fun remover(index: Int) {
        this.list.removeAt(index)
    }

    fun get(index: Int): Cor {
        return this.list.get(index)
    }

    fun get(): ArrayList<Cor> {
        return this.list
    }

    fun count(): Int {
        return this.list.count()
    }

}