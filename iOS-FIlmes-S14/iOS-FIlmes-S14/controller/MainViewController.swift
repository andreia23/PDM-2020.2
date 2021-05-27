//
//  ViewController.swift
//  iOS-FIlmes-S14
//
//  Created by IFPB on 27/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {

    @IBOutlet weak var lbQuantidade: UILabel!
    var cadastro: Cadastro!
        
    override func viewDidLoad() {
        super.viewDidLoad()
        self.cadastro = (UIApplication.shared.delegate as! AppDelegate).cadastro
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        self.lbQuantidade.text = String(self.cadastro.count())
            
    }
    
    
}
