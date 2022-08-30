package model.persistencia;
import java.util.List;

/**
 *
 * @author Ricardo
 */

// classe responsavel por disponibilizar uma interface (factory method)
public interface Crud {
    
    public Object cadastrar(Object objeto);
    public Object consultar(int id);
    public void deletar(int id);
    public Object atualizar(Object objeto);
    public List listar();
}
