/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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

    // envia as inormaçoes para a persistencia faendo o atualiar ou incluir um novo registro
    public Contato Cadastrar(Contato contato) {
        if (contato.getId() == 0) {
            return (Contato) persistencia.cadastrar(contato);
        }
        return (Contato) persistencia.atualizar(contato);

    }

    public List<Contato> listar() {
        return (List) this.persistencia.listar();
    }

    // realiza a consulta do contato
    public Contato consultar(int id) {
        Contato contato = (Contato) this.persistencia.consultar(id);

        if (contato.getId() == 0) {
            JOptionPane.showMessageDialog(null, "Contato não encontrado ");
        }

        return contato;
    }

}
