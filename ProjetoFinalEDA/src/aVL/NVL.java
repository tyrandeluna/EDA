package aVL;

public class NVL <A, B> {
	
	private NVL<A, B> direita;
	private NVL<A, B> esquerda;
	private B dados;
	private A value;
	private int h; //altura
	
	public NVL(A v) {
		this.value = v;
		this.setH(1);
	}

	public A getValue() {
		return value;
	}

	public void setValue(A v) {
		this.value = v;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public NVL<A, B> getDireita() {
		return direita;
	}

	public void setDireita(NVL<A, B> direita) {
		this.direita = direita;
	}

	public NVL<A, B> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NVL<A, B> esquerda) {
		this.esquerda = esquerda;
	}

	public B getDados() {
		return dados;
	}

	public void setDados(B d) {
		this.dados = d;
	}
		
}