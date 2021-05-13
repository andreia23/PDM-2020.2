//
//  main.swift
//  Forca
//
//  Created by andreia on 13/05/21.
//

import Foundation





var jogo = Forca(palavra: "elefante", dica: "Animal")

while(!jogo.finalizou()){
    print("Dica: \(jogo.dica)")
    print("Status da palavra: \(String(jogo.status))")
    print("Letras que ja foram jogada: \(String(jogo.letras))")
    print("Tentativas: \(10 - jogo.tentativas)")
    
    print("Digite uma letra: ")
    let letra =  Character(readLine()!)
    jogo.jogar(letra: letra)
}

print("Palavra correta: \(String(jogo.palavra))")
print("Resultado: \(jogo.resultado())")
