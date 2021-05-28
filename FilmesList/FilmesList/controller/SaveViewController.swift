//
//  SaveViewController.swift
//  FilmesList
//
//  Created by IFPB on 28/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class SaveViewController: UIViewController {

    var cadastro: Cadastro!
    var filme: Filme!
    var filmeParaEdicao: Int!
    
    @IBOutlet weak var tf_nome: UITextField!
    @IBOutlet weak var slider_nota: UISlider!
    @IBOutlet weak var valor_nota: UILabel!
    @IBOutlet weak var switch_indicado: UISwitch!
    @IBOutlet weak var stepper_assitido: UIStepper!
    @IBOutlet weak var lb_quantiAssistido: UILabel!
    
    @IBAction func sliderInsertNota(_ sender: Any) {
        self.valor_nota.text = String(Int(self.slider_nota.value))
    }
    
    @IBAction func insertVezesAssistido(_ sender: Any) {
        self.lb_quantiAssistido.text = String(Int(self.stepper_assitido.value))
        
    }
    
    @IBAction func saveFilme(_ sender: Any) {
        
        let nome = self.tf_nome.text!
        let nota = Int(self.slider_nota.value)
        let isIndicadoOscar = self.switch_indicado.isOn
        let quantiAssistido = Int(self.stepper_assitido.value)
        
        let filme = Filme(
            nome: nome,
            nota: nota,
            isIndicadoOscar: isIndicadoOscar,
            quantiAssistido: quantiAssistido
        )
        
        self.cadastro = (UIApplication.shared.delegate as! AppDelegate).cadastro
        self.cadastro.add(filme: filme)
        self.navigationController?.popViewController(animated: true)
        
    
    }
    
     override func viewWillAppear(_ animated: Bool) {
           super.viewWillAppear(true)
           if (self.filmeParaEdicao != nil){
               let filme = self.cadastro.get(index: self.filmeParaEdicao!)
               self.tf_nome.text = filme.nome
               self.slider_nota.value = Float(filme.nota)
               self.stepper_assitido.value = Double(filme.quantiAssistido)
               self.switch_indicado.isOn = filme.isIndicadoOscar
               
           }
           self.valor_nota.text = "\(Int(self.slider_nota.value))"
           self.lb_quantiAssistido.text = "\(Int(self.stepper_assitido.value))"
       }
    
}
