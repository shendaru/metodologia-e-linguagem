package objetos;

public class PessoaJuridica extends Pessoa {
	
	private String cnpj;

	public PessoaJuridica(String nome, String email, String celular, String cnpj) {
		super(nome, email, celular);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "CNPJ: " + getCnpj() + " Nome: " + getNome() + " Email: " + getEmail()
				+ " Celular: " + getCelular();
	}
}
