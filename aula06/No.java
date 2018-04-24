package aula06;

public class No {
	int dado;
	No esq, dir, pai;
	Cor cor;
	public No(){
		this.dado = 0;
		this.esq = null;
		this.dir = null;
		this.pai = null;
		cor = Cor.preto;
	}
	
	public No(int dado){
		this.dado = dado;
		this.esq = null;
		this.dir = null;
		this.pai = null;
		cor = Cor.preto;
	}
}
