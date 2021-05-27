//
//  ViewController.swift
//  Forca-iOS-S13
//
//  Created by IFPB on 27/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lb_dica: UILabel!
    @IBOutlet weak var lb_countLetras: UILabel!
    @IBOutlet weak var lb_letrasJogadas: UILabel!
    @IBOutlet weak var lb_tentativas: UILabel!
    @IBOutlet weak var lb_status: UILabel!
    @IBOutlet weak var imageForca: UIImageView!
    @IBOutlet weak var tf_letra: UITextField!
    var forca:Forca!
    
    
    @IBAction func jogar(_ sender: Any) {
        if(self.tf_letra.text?.count == 1){
            let letra = Character(self.tf_letra.text!)
            self.forca.jogar(letra: letra)
            self.update()
            if (self.forca.finalizou()){
                let resul = self.storyboard?.instantiateViewController(identifier: "viewResult") as! ResultViewController
                resul.result = self.forca.resultado()
                self.present(resul,animated: true, completion: nil)
                self.forca = Forca()
                self.update()
            }
        }else{
            let aviso = UIAlertController(title: "Aviso", message: "Informe uma letra!", preferredStyle: UIAlertController.Style.alert)
            aviso.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.cancel, handler: nil))
            self.present(aviso, animated: true, completion: nil)        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.forca = Forca()
    }
    
    func update() {
        self.lb_dica.text = self.forca.getDica()
        self.lb_countLetras.text = "Quantidade de letras: \(self.forca.palavra.count)"
        self.lb_letrasJogadas.text = String(self.forca.letras)
        self.lb_tentativas.text = "Restam \(10 - self.forca.tentativas) tentativas"
        self.lb_status.text = String(self.forca.status)
        self.imageForca.image = UIImage(named: self.forca.getImage())
        self.tf_letra.text = ""
        self.tf_letra.becomeFirstResponder()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        self.update()
    }
}


