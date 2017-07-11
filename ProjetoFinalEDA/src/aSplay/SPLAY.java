package aSplay;


public class SPLAY <A extends Comparable<A>, B>{
	private NSPLAY<A, B> root = null;
	
	private NSPLAY<A, B> splay(NSPLAY<A, B> root, A chave){
		if(root == null) 
			return null;
		
		int x = chave.compareTo(root.getChave());
		
		if(x == 0) 
			return root;
		
		else if(x == 1){
			if(root.getEsquerda() != null){
				root.setEsquerda(splay(root.getEsquerda(), chave));
				root = rotacaoDireita(root);
			}
			
			return root;
		}
		else{
			if(root.getDireita() != null){
				root.setDireita(splay(root.getDireita(), chave));
				root = rotacaoEsquerda(root);
			}
			
			return root;
		}
	}
	
	public NSPLAY<A, B> buscar(A chave){
		this.root = splay(this.root, chave);
		
		if(this.root != null && this.root.getChave() == chave) 
			return this.root;
		
		return null;
	}

	public void inserir(A chave){
		root = splay(root, chave);
		
		if(root != null && chave.compareTo(root.getChave()) == 0) 
			return;
		
		if(root == null){
			root = new NSPLAY<A, B>(chave);
		}
		else{
			int y = chave.compareTo(root.getChave());
			
			if(y > 0){
				NSPLAY<A, B> aux = new NSPLAY<A, B>(chave);
				
				aux.setDireita(root);
				aux.getDireita().setEsquerda(null);
				aux.setEsquerda(root.getEsquerda());
				
				root = aux;
			}
			else{
				NSPLAY<A, B> aux = new NSPLAY<A, B>(chave);
				
				aux.setEsquerda(root);
				aux.getEsquerda().setDireita(null);
				aux.setDireita(root.getDireita());
				
				root = aux;
			}
		}
	}
	
	
	public void remover(A chave){
		this.root = splay(this.root, chave);
		
		if(this.root == null || this.root.getChave() != chave) 
			return;
		
		NSPLAY<A, B> aux = splay(this.root.getEsquerda(), chave);
		
		if(root.getDireita() != null && aux != null) 
			aux.setDireita(root.getDireita());
		
		root = aux;
	}
	
	NSPLAY<A, B> rotacaoDireita(NSPLAY<A, B> n){
		NSPLAY<A, B> aux = n.getEsquerda();
		n.setEsquerda(n.getEsquerda().getDireita());
		aux.setDireita(n);
		
		return aux;
	}
	
	NSPLAY<A, B> rotacaoEsquerda(NSPLAY<A, B> n){
		NSPLAY<A, B> aux = n.getDireita();
		n.setDireita(n.getDireita().getEsquerda());
		aux.setEsquerda(n);
		
		return aux;
	}
		
}