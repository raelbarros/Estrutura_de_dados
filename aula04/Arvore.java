package aula04;

public class Arvore {
	private No raiz;
	
	public Arvore(){ raiz = null; }
	
	
	void inserir(int dado){
		raiz = inserir(raiz, new No(dado));
	}


	private No inserir(No p, No novo) {
		
		if (p == null)
			return novo;
		if (novo.dado < p.dado)
			 p.esq = inserir(p.esq, novo);
		else p.dir = inserir(p.dir, novo);
		
		return p;
	}


	public void mostrar() {
		inOrdem(raiz);
		
	}


	private void inOrdem(No p) {
		if (p != null){
			inOrdem(p.esq);
			System.out.println(p.dado);
			inOrdem(p.dir);
		}
		
	}
	
}
