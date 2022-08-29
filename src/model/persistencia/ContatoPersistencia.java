package model.persistencia;

import java.sql.Connection;
import model.conexao.Conexao;
import model.entidade.Contato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ContatoPersistencia implements Crud {

    public final Connection conexao;
    public Contato contato;

    public ContatoPersistencia() throws InstantiationException, IllegalAccessException {
        conexao = Conexao.getConexao();
    }

    @Override
    public Object cadastrar(Object objeto) {
        this.contato = (Contato) objeto;

        try {

            PreparedStatement ps = conexao.prepareStatement("insert into contatos (nome, telefone, email) values(?,?,?)");
            ps.setString(1, this.contato.getNome());
            ps.setString(2, this.contato.getTelofone());
            ps.setString(3, this.contato.getEmail());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.contato;

    }

    @Override
    public Object consultar(int id) {

        try {

            PreparedStatement ps = conexao.prepareStatement("select * from contatos where id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setTelofone(rs.getString("telefone"));
            }

            return contato;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        try {
            PreparedStatement ps
                    = conexao.prepareStatement("DELETE FROM contatos WHERE id =?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Object objeto, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator listar() {
        List<Contato> contatos = new ArrayList<>();
        try {

            PreparedStatement ps = this.conexao.prepareStatement("select * from contatos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                this.contato.setId(rs.getInt("id"));
                this.contato.setNome(rs.getString("nome"));
                this.contato.setEmail(rs.getString("email"));
                this.contato.setTelofone(rs.getString("telefone"));
                contatos.add(this.contato);
            }
            return contatos.iterator();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;

    }
}
