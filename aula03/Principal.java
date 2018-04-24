package aula03;

public class Principal {

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		arvore.inserir(100);
		arvore.inserir(30);
		arvore.inserir(10);
		arvore.inserir(40);
		arvore.inserir(140);
		arvore.inserir(110);
		arvore.inserir(200);
		
		arvore.inOrdemRecursivo();
		
		System.out.println(arvore.soma());
		
	}

}
