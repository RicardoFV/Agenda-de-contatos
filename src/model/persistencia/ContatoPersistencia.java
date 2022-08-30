package model.persistencia;

import java.sql.Connection;
import model.conexao.Conexao;
import model.entidade.Contato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ContatoPersistencia implements Crud {

    public final Connection conexao;
    public Contato contato;

    public ContatoPersistencia() throws InstantiationException, IllegalAccessException {
        this.conexao = Conexao.getConexao();
    }

    @Override
    public Object cadastrar(Object objeto) {
        try {
            this.contato = (Contato) objeto;

            PreparedStatement ps = this.conexao.prepareStatement("insert into contatos (nome, telefone, email) values(?,?,?)");
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

            PreparedStatement ps = this.conexao.prepareStatement("select * from contatos where id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Contato contatoAdd = new Contato();
            while (rs.next()) {

                contatoAdd.setId(rs.getInt("id"));
                contatoAdd.setNome(rs.getString("nome"));
                contatoAdd.setEmail(rs.getString("email"));
                contatoAdd.setTelofone(rs.getString("telefone"));
            }
            return contatoAdd;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        try {
            PreparedStatement ps
                    = this.conexao.prepareStatement("DELETE FROM contatos WHERE id =?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Object atualizar(Object objeto) {
        try {
            this.contato = (Contato) objeto;

            PreparedStatement ps = this.conexao.prepareStatement("update contatos set nome =?, telefone =?, email=? where id = ?");
            ps.setString(1, this.contato.getNome());
            ps.setString(2, this.contato.getTelofone());
            ps.setString(3, this.contato.getEmail());
            ps.setInt(4, contato.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return this.contato;
    }

    @Override
    public List listar() {
        List<Contato> contatos = new ArrayList<>();
        try {

            PreparedStatement ps = this.conexao.prepareStatement("select * from contatos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Contato contatoAdd = new Contato();

                contatoAdd.setId(rs.getInt("id"));
                contatoAdd.setNome(rs.getString("nome"));
                contatoAdd.setEmail(rs.getString("email"));
                contatoAdd.setTelofone(rs.getString("telefone"));
                contatos.add(contatoAdd);
            }
            return (List) contatos;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;

    }

   
}
