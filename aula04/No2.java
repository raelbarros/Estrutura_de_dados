package aula04;

public class No2 {
	int dado;
	No2 esq, dir;
	
	public No2(int dado){
		this.dado = dado;
		esq = dir = null;
	}

	public void inserirSubArvore(int dado) {
		if (dado < this.dado)
			inserirEsq(dado);
		else inserirDir(dado);
		
	}

	private void inserirEsq(int dado) {
		if (esq == null)
			esq = new No2(dado);
		else esq.inserirSubArvore(dado);
	}
	
	private void inserirDir(int dado){
		if (dir == null)
			dir = new No2(dado);
		else dir.inserirSubArvore(dado);
	}
}
