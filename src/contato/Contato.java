/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contato;

import model.conexao.Conexao;

/**
 *
 * @author Ricardo
 */
public class Contato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Conexao conexao = new Conexao();
        
        System.out.println(conexao.getConexao());
    }
    
}
