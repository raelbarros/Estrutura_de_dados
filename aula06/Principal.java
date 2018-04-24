package aula06;

public class Principal {
	public static void main(String[] args) {
		ArvoreRN arvore = new ArvoreRN();
		
		arvore.inserir(34);
		arvore.inserir(3);
		arvore.inserir(50);
		arvore.inserir(20);
		arvore.inserir(15);
		arvore.inserir(16);
		arvore.inserir(25);
		arvore.inserir(27);
		
		arvore.mostrar();
	}
}
