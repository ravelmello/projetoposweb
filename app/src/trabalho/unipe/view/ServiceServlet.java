package trabalho.unipe.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trabalho.unipe.entity.Pessoa;
import trabalho.unipe.persistence.PessoaDao;

@WebServlet("/service.do")
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PessoaDao dao;
       
 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("search")) {
			search(request, response);
		}
		
		if(action.equalsIgnoreCase("delete")) {
			delete(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert")) {
			insert(request, response);
		}
		
		if(action.equalsIgnoreCase("update")) {
			update(request, response);
		}
	}

	/**
	 * Metodo resposnsável por fazer a inserção dos dados do formulário de cadastro no banco de dados.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome 	= request.getParameter("nome");
		String cpf 		= request.getParameter("cpf");
		String cep		= request.getParameter("cep");
		String bairro 	= request.getParameter("bairro");
		String logradouro = request.getParameter("logradouro");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setCpf(cpf);
		pessoa.setCep(cep);
		pessoa.setLogradouro(logradouro);
		pessoa.setBairro(bairro);
		
		try {
			PessoaDao dao = new PessoaDao();
			dao.insert(pessoa);
			request.setAttribute("msg", "Pessoa cadastrada com sucesso!");
		} catch (Exception e) {
			request.setAttribute("msg", "Opsss!! " + e.getMessage());
		} finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * Metodo responsável por atualizar os dados da pessoa.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = new Integer(request.getParameter("id"));
		
		String nome 	= request.getParameter("nome");
		String cpf 		= request.getParameter("cpf");
		String cep		= request.getParameter("cep");
		String bairro 	= request.getParameter("bairro");
		String logradouro = request.getParameter("logradouro");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(id);
		pessoa.setNome(nome);
		pessoa.setCpf(cpf);
		pessoa.setCep(cep);
		pessoa.setLogradouro(logradouro);
		pessoa.setBairro(bairro);
		
		try {
			PessoaDao dao = new PessoaDao();
			dao.update(pessoa);
			request.setAttribute("msg", "Pessoa atualizada com sucesso!");
		} catch (Exception e) {
			request.setAttribute("msg", "Opsss!! " + e.getMessage());
		} finally {
			request.getRequestDispatcher("listar.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * Metodo responsável por remover os dados da pessoa.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = new Integer(request.getParameter("id"));
		
		try {
			PessoaDao dao = new PessoaDao();
			dao.delete(id);
			request.setAttribute("msg", "Pessoa deletada com sucesso!");
			request.getRequestDispatcher("listar.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Opsss!! " + e.getMessage());
			request.getRequestDispatcher("listar.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * Metodo responsavel por trazer apenas um registro de uma pessoa do banco de dados.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = new Integer(request.getParameter("id"));
		
		try {
			PessoaDao dao = new PessoaDao();
			Pessoa pessoa = dao.findByOne(id);
			
			request.setAttribute("pessoa", pessoa);
			request.getRequestDispatcher("alterar.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Opsss!! " + e.getMessage());
			request.getRequestDispatcher("listar.jsp").forward(request, response);
		}
	}
}
