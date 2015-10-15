package trabalho.unipe.entity;

/**
 * @author Thomas Matheus
 */
public class Pessoa {

	private Integer id;
	private String nome;
	private String cpf;
	private String cep;
	private String bairro;
	private String logradouro;
	
	public Pessoa() { }
	
	public Pessoa(Integer id, String nome, String cpf, String cep, String bairro, String logradouro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.bairro = bairro;
		this.logradouro = logradouro;
	}
	
	@Override
	public String toString() {
		return "Pessoa (ID  = " + this.id
			   		  +"CPF = " + this.cpf
			   		  +"CEP = " + this.cep
			   		  +"BAIRRO = " + this.bairro
			   		  +"LOGRADOURO = " + this.logradouro;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}	
}
