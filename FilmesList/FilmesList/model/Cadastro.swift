//
//  Cadastro.swift
//  FilmesList
//
//  Created by IFPB on 28/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import Foundation

class Cadastro {
    private var lista: Array<Filme>
    
    init() {
        self.lista = Array()
    }
    
    func add(filme: Filme) {
        self.lista.append(filme)
    }
    
    func count() -> Int {
        return self.lista.count
    }
    
    func get(index: Int) -> Filme {
        return self.lista[index]
    }
    
    func get() -> Array<Filme> {
        return self.lista
    }
    
    func del(index: Int) {
        self.lista.remove(at: index)
    }
    
    func mov(de: Int, para: Int){
        
    }
    
    func update(index: Int, filme: Filme){
        self.lista[index] = filme
    }
}
