package aula02;

public class ListaEncadeada {

	No inicio;
	
	public ListaEncadeada(){
		inicio = null;
	}
	
	boolean vazia(){
		return (inicio == null);
	}
	
	
	void mostrar(){
		No aux = inicio;
		
		while(aux != null) {
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}
	}
	
	void inserir(int dado){
		No novo = new No(dado);
		novo.setProx(inicio);
		inicio = novo;
	}
	
	void inserirFim(int dado){
		No novo = new No(dado);
		
		if (vazia() == true)
			inicio = novo;
		else {
			No aux = inicio;
			// achar o ultimo elemento
			while (aux.getProx() != null){
				aux = aux.getProx();
			}
			
			aux.setProx(novo);
		}
	}
	
	void inserirOrdem(int dado){
		No novo = new No(dado);
		
		if (this.vazia() == true)
			inicio = novo;
		else { 
			No aux, ant;
			
			ant = null;
			aux = inicio;
			
			while (aux != null && aux.getDado() < dado){
				ant = aux;
				aux = aux.getProx();
			}
			
			if (aux == inicio){
				novo.setProx(inicio);
				inicio = novo;
			} else {
				ant.setProx(novo);
				novo.setProx(aux);
			}
			
		}
	}
	
	
	
	
	
	
}
