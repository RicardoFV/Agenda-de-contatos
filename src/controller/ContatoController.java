/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.entidade.Contato;
import model.persistencia.ContatoPersistencia;

/**
 *
 * @author Ricardo
 */
public class ContatoController {
    
    private final ContatoPersistencia persistencia;

    public ContatoController() throws InstantiationException, IllegalAccessException {
        this.persistencia = new ContatoPersistencia();
    }
    
    // envia as inormaçoes para a persistencia
    public void Cadastrar(Contato contato )
    {
        persistencia.cadastrar(contato);
    }
    
    public void listar()
    {
         
    }
    
}
