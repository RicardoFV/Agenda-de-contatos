package model.persistencia;

import java.util.Iterator;

/**
 *
 * @author Ricardo
 */
public interface Crud {
    
    public Object cadastrar(Object objeto);
    public Object consultar(int id);
    public void deletar(int id);
    public Object atualizar(Object objeto, int id);
    public Iterator listar();
}
