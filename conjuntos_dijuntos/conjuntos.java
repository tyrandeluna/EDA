package conjuntos_dijuntos;

public class conjuntos {
	private int pai[] = null;
	private int ordem[] = null;
	private int n = 0;
	
	public conjuntos(int n){
		this.n = n;
		pai = new int [n];
		ordem = new int [n];
	}
	
	public void make_set(int i){
		pai[i] = i;
		ordem [i] = 0;
	}
	
	public void make_set_all(){
		for(int i = 0; i < n; i++)
			make_set(i);
	}
	
	public int find_Set1(int v){
		if(v == pai [v])
			return v;
		else return find_Set1(pai[v]);
	}
	
	public int find_Set(int v){
		if(v == pai[v])
			return v;
		else{
			int pais = find_Set(pai[v]);
			pai[v] = pais;
			return pais;
		}
	}
}
