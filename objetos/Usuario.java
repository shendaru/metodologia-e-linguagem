package objetos;

public class Usuario {
	
	private String login;
	private String senha;
	private String matricula;
	private String nome;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	public Usuario(String login, String senha, String matricula, String nome) {
		this.login = login;
		this.senha = senha;
		this.matricula = matricula;
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
