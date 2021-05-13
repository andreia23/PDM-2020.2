//
//  Forca.swift
//  Forca
//
//  Created by andreia on 13/05/21.
//

import Foundation

class Forca {
    var palavra: Array<Character>
    var status: Array<Character>
    var dica: String
    var tentativas: Int
    var letras: Array<Character>
    
    init(palavra: String, dica: String){
        self.palavra = Array(palavra)
        self.dica = dica
        self.letras = Array()
        self.tentativas = 0
        self.status = Array(repeating: "_", count: self.palavra.count)
    }
    
    func validarJogada(letra: Character) -> Bool{
        return !self.letras.contains(letra) && self.palavra.contains(letra) &&
            self.tentativas < 10
    }
    
    func jogar(letra: Character){
        if (self.validarJogada(letra: letra)){
            self.letras.append(letra)
            for i in 0..<self.palavra.count{
                if (self.palavra[i] == letra){
                    self.status[i] = letra
                }
            }
        }else{
            self.tentativas += 1
        }
    }
    
    func finalizou() -> Bool {
        return self.palavra == self.status || self.tentativas >= 10;
    }
    
    func resultado() -> String{
        if (self.finalizou()){
            if (self.palavra == self.status){
                return "Você ganhou"
            }else{
                return "Você perdeu"
            }
        }else{
            return "O jogo ainda não acabou"
        }
    }
}




