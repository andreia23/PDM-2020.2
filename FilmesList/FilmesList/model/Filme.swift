//
//  Filme.swift
//  FilmesList
//
//  Created by IFPB on 28/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

class Filme: NSObject {
    var nome: String
    var nota: Int
    var isIndicadoOscar: Bool
    var quantiAssistido: Int
    
    override var description: String{
        return "\(self.nome) - \(self.nota) - \(self.isIndicadoOscar) - \(self.quantiAssistido)"
    }
    
    init(nome: String, nota: Int, isIndicadoOscar: Bool, quantiAssistido: Int) {
        self.nome = nome
        self.nota = nota
        self.isIndicadoOscar = isIndicadoOscar
        self.quantiAssistido = quantiAssistido
    }
}
