package aula05;

public class Arvore {
	private No raiz;
	
	public Arvore(){
		raiz = null;
	}
	
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
	
	private No maior(No q){
		while (q != null && q.dir != null){
			q = q.dir;
		}
		return q;
	}
	
	private No menor(No q){
		while (q != null && q.esq != null){
			q = q.esq;
		}
		return q;
	}
	
	public void remover(int k){
		raiz = remover(raiz, k);
	}

	private No remover(No p, int k) {
		if (p != null){
			
			if (k < p.dado){
				p.esq = remover(p.esq, k);
			} else if (k > p.dado) {
				p.dir = remover(p.dir, k);
			} else if (k == p.dado) {
				// caso 1: o nó p é folha
				if (p.esq == null && p.dir == null) {
					return null;
				}
				// caso 2: o nó p tem filho esquerdo
				else if (p.esq != null){
					No q  = maior(p.esq);
					p.dado = q.dado;
					p.esq = remover(p.esq, q.dado);
				}
				
				// caso 3: o nó p tem filho direito
				else if (p.dir != null){
					No q = menor(p.dir);
					p.dado = q.dado;
					p.dir = remover(p.dir, q.dado);
				}
				
			}
			
			
		}
		return p;
	}
	
	
	
	
}
