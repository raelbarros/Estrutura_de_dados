package aula03;

import java.util.Stack;

public class Arvore {
	private No raiz;
	
	public Arvore(){
		raiz = null;
	}
	
	public void inserir(int dado){
		No novo = new No(dado);
		
		if (raiz == null){
			raiz = novo;
		} else {
			No aux = raiz;
			No ant = null;
			while (aux != null){
				ant = aux;
				if (dado < aux.dado)
					aux = aux.esq;
				else if (dado > aux.dado)
					aux = aux.dir;
				else if (dado == aux.dado)
					return;
			}
			
			if(dado < ant.dado)
				ant.esq = novo;
			else ant.dir = novo;
		}
	}
	
	public void preOrdemIterativo(){
		Stack<No> pilha = new Stack<>();
		No p = raiz;
		while (p != null || !pilha.isEmpty()){
			if (p != null){
				System.out.println(p.dado);
				pilha.push(p);
				p = p.esq;
			} else {
				p = pilha.pop();
				p = p.dir;
			}
		}
	}
	
	public void preOrdemRecursivo(){
		preOrdem(raiz);
	}

	private void preOrdem(No p) {
		if (p != null){
			System.out.println(p.dado);
			preOrdem(p.esq);
			preOrdem(p.dir);
		}
		
	}
	
	public void inOrdemRecursivo(){
		inOrdem(raiz);
	}

	private void inOrdem(No p) {
		if (p != null){
			inOrdem(p.esq);
			System.out.println(p.dado);
			inOrdem(p.dir);
		}
		
	}
	
	public int soma(){
		return soma(raiz);
	}

	private int soma(No p) {
		if (p != null){
			return soma(p.esq) + soma(p.dir) + p.dado;
		}
		return 0;
	}
	
	
	
}
