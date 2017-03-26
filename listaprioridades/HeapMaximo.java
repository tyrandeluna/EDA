package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */
public class HeapMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapMaximo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	private void subir(int i){
		int j = i/2;
		if(j >= 1){
			if(vetor[j] < vetor[i]){
				int jValue = vetor[j];
				int iValue = vetor[i];
				vetor[j] = iValue;
				vetor[i] = jValue;
				subir(j);
			}
		}
	}
	
	private void descer(int i){
		int j = 2*i;
		if(j + 1 <= n && (vetor[j+1] > vetor[j])){
			j++;
			if(vetor[j] > vetor[i]){
				int jValue = vetor[j];
				int iValue = vetor[i];
				vetor[j] = iValue;
				vetor[i] = jValue;
				descer(j);
			}
		}
	}
	
	public void contruir(List<Integer> entrada){
		for(int i = 1; i <= entrada.size(); i++){
			vetor[i] = entrada.get(i - 1);
			n++;
 		}
		for(int i = n/2; i >= 1; i--)
			descer(i);
	}
	
	public int getMaximaPrioridade(){
		return 0;
	}
	
	public int remove(){
		if(n >= 1){
			int aux = vetor[0];
			int uValue = vetor[0];
			int nValue = vetor[n];
			vetor[0] = nValue;
			vetor[n] = uValue;
			n--;
			descer(0);
			return aux;
		}
		return -1;
	}	
	
	public void inserir(int prioridade){
		if(n < nMaximo){
			vetor[n+1] = prioridade;
			n++;
			subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		for(int i = 1; i <= n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
				if(novaPrioridade > prioridade){
					subir(i);
					return;
				}
				else{
					descer(i);
					return;
				}
			}
		}
	}	
}
