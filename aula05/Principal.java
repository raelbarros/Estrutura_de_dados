package aula05;

public class Principal {

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		
		arvore.inserir(10);
		arvore.inserir(3);
		arvore.inserir(18);
		arvore.inserir(2);
		arvore.inserir(8);
		arvore.inserir(15);
		arvore.inserir(6);
		
		arvore.remover(2);
		arvore.remover(3);
		
		arvore.mostrar();
	}

}
