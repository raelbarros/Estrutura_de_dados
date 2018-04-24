package aula04;

public class Arvore2 {
	private No2 raiz;
	public Arvore2(){
		raiz = null;
	}
	
	void inserir(int dado){
		if (raiz == null)
			raiz = new No2(dado);
		else raiz.inserirSubArvore(dado);
	}

	public void mostrar() {
		inOrdem(raiz);
		
	}


	private void inOrdem(No2 p) {
		if (p != null){
			inOrdem(p.esq);
			System.out.println(p.dado);
			inOrdem(p.dir);
		}
		
	}

	
}
