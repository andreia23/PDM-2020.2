//
//  FilmesTableViewController.swift
//  FilmesList
//
//  Created by IFPB on 28/05/21.
//  Copyright © 2021 IFPB. All rights reserved.
//

import UIKit

class FilmesTableViewController: UITableViewController {

    var cadastro: Cadastro!

    override func viewDidLoad() {
        super.viewDidLoad()
        self.cadastro = (UIApplication.shared.delegate as! AppDelegate).cadastro
        self.navigationItem.leftBarButtonItem = self.editButtonItem
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.cadastro.count()
        
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "filme", for: indexPath)
        
        let filme = self.cadastro.get(index: indexPath.row)

        cell.textLabel?.text = filme.nome
        cell.detailTextLabel?.text = String(filme.nota)
        return cell
    }
    
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        return true
    }

    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            self.cadastro.del(index: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .fade)
        }
    }
    
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
        self.cadastro.mov(de: fromIndexPath.row, para: to.row)
    }

    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        return true
    }
        
     override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
           let svc = self.storyboard?.instantiateViewController(identifier: "formulario") as! SaveViewController
           svc.filmeParaEdicao = indexPath.row
           self.navigationController?.pushViewController(svc, animated: true)
       }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    
    override func viewDidAppear(_ animated: Bool) {
          super.viewDidAppear(true)
          self.tableView.reloadData()
    }}
