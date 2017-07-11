package Pessoa;

public class PESSOA implements Comparable<PESSOA>{
	
	private String nome;
	private String cpf;
	private int rg;
	private String data_nasc;
	private String email;
	
	public PESSOA(String nome, String cpf, int rg, String data_nasc, String email){
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.data_nasc = data_nasc;
		this.email = email;
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
	public int getRG() {
		return rg;
	}
	public void setRG(int rg) {
		this.rg = rg;
	}
	public String getDataNasc() {
		return data_nasc;
	}
	public void setData_de_abertura(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(PESSOA o) {
		if(this.rg == o.getRG())
			return 0;
		if(this.rg != o.getRG()){
			if(this.rg > o.getRG()) 
				return 1;
			else if(this.rg < o.getRG()) 
				return -1;
		}
		return 0;
	}

}