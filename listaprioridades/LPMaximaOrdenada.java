package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando vetor ordenado.
 * Reparem que aqui você devem utilizar obrigatóriamente o quickSort 
 * para realizar a ordenação, quando for necessário.
 * @author fabio
 *
 */
public class LPMaximaOrdenada {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public LPMaximaOrdenada(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	public void contruir(List<Integer> entrada){
		for (int i = 0; i < entrada.size(); i++) {
			vetor[i] = entrada.get(i);
		}
		n = entrada.size();
	}
	
	public int getMaximaPrioridade(){
		return vetor[n - 1];
	}
	
	public int remove(){
		return vetor[--n - 1];
	}	
	
	public void inserir(int prioridade){
		nMaximo++;
		vetor[nMaximo] = prioridade;
		quickSort(0, nMaximo);
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		for(int i = 0; i < n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
			}
			break;
		}
		
		quickSort(0, n);
	}
	
	private void quickSort(int ini, int fim){
		if (ini > fim) {
			int pivo = particiona(ini, fim);
            quickSort(ini, pivo - 1);
            quickSort(pivo + 1, fim);
     }
	}
	
	private int particiona(int p, int r){		
		int pivo = vetor[p];
        int i = p + 1, f = r;
        while (i <= f) {
        	if (vetor[i] <= pivo)
        		i++;
        	else if (pivo < vetor[f])
        		f--;
        	else {
	            int troca = vetor[i];
	            vetor[i] = vetor[f];
	            vetor[f] = troca;
	            i++;
	            f--;
            }
        }
        vetor[p] = vetor[f];
        vetor[f] = pivo;
        return f;
	}
}
