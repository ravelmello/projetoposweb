package trabalho.unipe.manager;

import java.util.ArrayList;
import java.util.List;

import trabalho.unipe.persistence.PessoaDao;

/**
 * @author Thomas Matheus
 */
public class ManagerBean {

	private List lista;
	
	/**
	 * 
	 * @return List
	 */
	public List getLista() {
		
		try {
			lista = new ArrayList<>();
			lista = new PessoaDao().findAll();
		} catch (Exception e) {
			System.out.println("Opsss!! Ocorreu um problema durante a consulta \n " + e.getMessage());
		}
		
		return lista;
	}
	
	/**
	 * 
	 * @param List lista
	 */
	public void setLista(List lista) {
		this.lista = lista;
	}
}
