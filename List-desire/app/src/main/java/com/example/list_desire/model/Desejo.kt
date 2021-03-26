package com.example.list_desire.model

import java.io.Serializable

var id = 0
class Desejo: Serializable {
    var idDesejo: Int
    var descricao: String
    var valor: Float

    constructor(descricao: String, valor: Float){
        this.idDesejo = ++id
        this.descricao = descricao
        this.valor = valor
    }
    override fun toString(): String {
        return "${this.descricao} - R$ ${this.valor}"
    }
}