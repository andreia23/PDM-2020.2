//
//  SaveViewController.swift
//  iOS-FIlmes-S14
//
//  Created by IFPB on 27/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class SaveViewController: UIViewController {

    @IBOutlet weak var tf_nome: UITextField!
    @IBOutlet weak var slider_nota: UISlider!
    @IBOutlet weak var valor_nota: UILabel!
    @IBOutlet weak var switch_indicado: UISwitch!
    @IBOutlet weak var stepper_assitido: UIStepper!
    @IBOutlet weak var lb_quantiAssistido: UILabel!
    
    var cadastro: Cadastro!
    var filme: Filme!
       
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
        self.navigationController?.popViewController(animated: true)
    
    }
    
    
}
