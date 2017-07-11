package aVL;

public class AVL <A extends Comparable<A>, B> {
	
	private NVL<A, B> root;
	
	public void inserir(A value){
		root = inserirr(root, value);
	}
	
	public AVL(){
		root = null;
	}
	
	NVL<A, B> inserirr(NVL<A, B> n, A value){
		if(n == null){
			NVL<A, B> aux = new NVL<A, B>(value);
			
			return aux;
		}
		int v = value.compareTo(n.getValue());
		
		if(v < 0){
			n.setEsquerda(inserirr(n.getEsquerda(), value));
			
			if((h(n.getEsquerda()) - h(n.getDireita())) == 2){
				
				if(h(n.getEsquerda().getEsquerda()) > h(n.getEsquerda().getDireita())){
					n = rotacaoDireita(n);
				}
				
				else{
					n = rduplaDireita(n);
				}
			}
		}
		else if(v > 1){
			n.setDireita(inserirr(n.getDireita(), value));
			
			if((h(n.getDireita()) - h(n.getEsquerda())) == 2){
				
				if(h(n.getDireita().getDireita()) > h(n.getDireita().getEsquerda())){
					n = rotacaoEsquerda(n);
				}
				
				else{
					n = rEsquerda(n);
				}
			}
		}
		
		n.setH(((h(n.getDireita()) > h(n.getEsquerda())) ? h(n.getDireita()) : (h(n.getEsquerda()))) + 1);
		
		return n;
	}
	
	int h(NVL<A, B> n){
		return (n != null ? n.getH() : 0);
	}
	
	NVL<A, B> rotacaoDireita(NVL<A, B> n){
		NVL<A, B> aux = n.getEsquerda();
		
		n.setEsquerda(n.getEsquerda().getDireita());
		aux.setDireita(n);
		
		n.setH((h(n.getDireita()) > h(n.getDireita()) ? h(n.getDireita()) : (h(n.getEsquerda())) + 1));
		aux.setH((h(aux.getDireita()) > h(aux.getDireita()) ? h(aux.getDireita()) : (h(aux.getEsquerda())) + 1));
		
		return aux;
	}
	
	NVL<A, B> rotacaoEsquerda(NVL<A, B> n){
		NVL<A, B> aux = n.getDireita();
		
		n.setDireita(n.getDireita().getEsquerda());
		aux.setEsquerda(n);
		
		n.setH((h(n.getDireita()) > h(n.getDireita()) ? h(n.getDireita()) : (h(n.getEsquerda())) + 1));
		aux.setH((h(aux.getDireita()) > h(aux.getDireita()) ? h(aux.getDireita()) : (h(aux.getEsquerda())) + 1));
		
		return aux;
	}
	
	NVL<A, B> rduplaDireita(NVL<A, B> n){
		n.setEsquerda(rotacaoEsquerda(n.getEsquerda()));
		n = rotacaoDireita(n);
		
		return n;
	}
	
	NVL<A, B> rEsquerda(NVL<A, B> n){
		n.setDireita(rotacaoDireita(n.getDireita()));
		n = rotacaoEsquerda(n);
		
		return n;
	}
	
	private NVL<A, B> buscaa(NVL<A, B> n, A value){
		if(n == null) 
			return null;
		
		int w = value.compareTo(n.getValue());
		
		if(w > 0)
			return buscaa(n.getDireita(), value);
		else if(w < 0)
			return buscaa(n.getEsquerda(), value);
		
		return n;
	}
	
	public NVL<A, B> busca(A value){
		return buscaa(root, value);
	}
	
	public void remover(A value){
		root = remover_r(root, value);
	}
	
	NVL<A, B> remover_r(NVL<A, B> n, A value){
		if(n == null)
			return null;
		
		int t = value.compareTo(n.getValue());
		
		if(t == 1){
			n.setDireita(remover_r(n.getDireita(), value));
			
			if((h(n.getEsquerda()) - h(n.getDireita())) == 2){
				
				if(h(n.getEsquerda().getEsquerda()) > h(n.getEsquerda().getDireita())){
					n = rotacaoDireita(n);
				}
				
				else{
					n = rduplaDireita(n);
				}
			}
		}
		
		else if(t == -1){
			n.setEsquerda(remover_r(n.getEsquerda(), value));
			
			if((h(n.getDireita()) - h(n.getEsquerda())) == 2){
				
				if(h(n.getDireita().getDireita()) > h(n.getDireita().getEsquerda())){
					n = rotacaoEsquerda(n);
				}
				else{
					n = rEsquerda(n);
				}
			}
		}
		else{
			if(n.getDireita() == null || n.getEsquerda() == null){
				
				if(n.getDireita() == null && n.getDireita() == null)
					return null;
				
				if(n.getDireita() == null){
					n = n.getEsquerda();
				}
				else{
					n = n.getDireita();
				}
			}
			else{
				NVL<A, B> aux = menor(n.getDireita());
				n.setValue(aux.getValue());
				n.setDireita(remover_r(n.getDireita(), aux.getValue()));
			}
		}
		n.setH(((h(n.getDireita()) > h(n.getEsquerda())) ? h(n.getDireita()) : (h(n.getEsquerda()))) + 1);
		
		return n;
	}
	
	NVL<A, B> menor(NVL<A, B> n){
		NVL<A, B> aux = n;
		
		while(aux.getEsquerda() != null)
			aux = aux.getEsquerda();
		
		return aux;
	}

}