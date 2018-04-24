package aula03;

public class No {
	int dado;
	No esq, dir;
	
	public No(){
		dado = 0;
		esq = dir = null;
	}
	
	public No(int dado){
		this.dado = dado;
		esq = dir = null;
	}
}
