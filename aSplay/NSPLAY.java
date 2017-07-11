package aSplay;

public class NSPLAY <A, B> {
	
	private NSPLAY<A, B> esquerda;
	private NSPLAY<A, B> direita;
	private A chave;
	private B dados;
	
	public NSPLAY(A chave){
		this.chave = chave;
		this.esquerda = null;
		this.direita = null;
	}

	public NSPLAY<A, B> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NSPLAY<A, B> esquerda) {
		this.esquerda = esquerda;
	}

	public NSPLAY<A, B> getDireita() {
		return direita;
	}

	public void setDireita(NSPLAY<A, B> direita) {
		this.direita = direita;
	}
	
	public A getChave() {
		return chave;
	}

	public void setChave(A chave) {
		this.chave = chave;
	}
	
	public B getDados() {
		return dados;
	}

	public void setDados(B dados) {
		this.dados = dados;
	}
}