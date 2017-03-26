package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.ufc.quixada.eda.listaprioridades.HeapMaximo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteListaPrioridadesHeap {
	public static void main(String args[]){
		Scanner pausa = new Scanner(System.in);
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {				
				String path = EDAConstants.caminhoPasta + "tarefa" + tamanho + ".txt";
				List<Integer> entrada = EDAUtil.getDadosIniciais(path);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE INSER��ES
				String arquivoOperacao = "operacoesI_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				List<Operacao> operacoes = EDAUtil.getOperacoes(path);
				
				long tempoInicial = System.currentTimeMillis();				
				HeapMaximo listaPrioridade = new HeapMaximo(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}	
				long tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
				// GAmBIARRA
				String para = pausa.next();
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE ALTERA��ES
				arquivoOperacao = "operacoesA_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new HeapMaximo(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
				// GAmBIARRA
				
				para = pausa.next();
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE REMO��O
				arquivoOperacao = "operacoesR_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new HeapMaximo(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
				// GAmBIARRA
				para = pausa.next();
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE SELE��O
				arquivoOperacao = "operacoesS_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new HeapMaximo(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
				// GAmBIARRA
				para = pausa.next();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
