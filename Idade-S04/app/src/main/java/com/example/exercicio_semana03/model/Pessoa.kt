package com.example.exercicio_semana03.model

import java.io.Serializable
import java.util.*

class Pessoa : Serializable {
    var nome: String
    var ano: Int
    constructor(nome: String, ano: Int){
        this.nome = nome
        this.ano = ano
    }
    fun idade(): Int{
        return 2021 - this.ano
    }
}