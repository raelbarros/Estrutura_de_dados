package aula06;

public class ArvoreRN {

	No raiz;
	No nulo;

	public ArvoreRN() {
		nulo = new No();
		nulo.esq = nulo.pai = nulo.dir = nulo;
		raiz = nulo;
	}

	private void rotacaoEsq(No x) {
		No y = x.dir;

		x.dir = y.esq;

		if (y.esq != nulo)
			y.esq.pai = x;

		y.pai = x.pai;

		if (x.pai == nulo)
			raiz = y;
		else {
			if (x.pai.esq == x)
				x.pai.esq = y;
			else
				x.pai.dir = y;
		}

		x.pai = y;
		y.esq = x;

	}
	
	public void mostrar(){
		inOrdem(raiz, "    ");
	}
	
	private void inOrdem(No p, String espaco){
		if (p != nulo){
			inOrdem(p.esq, espaco + "      ");
			System.out.println(espaco + p.dado + "," + p.cor);
			inOrdem(p.dir, espaco + "      ");
		}
	}

	private void rotacaoDir(No y) {
		No x = y.esq;

		y.esq = x.dir;

		if (y.esq != nulo)
			y.esq.pai = x;

		x.pai = y.pai;

		if (y.pai == nulo)
			raiz = x;
		else {
			if (y.pai.esq == y)
				y.pai.esq = x;
			else
				y.pai.dir = x;
		}

		y.pai = x;
		x.dir = y;
	}

	public void inserir(int dado) {

		No p, ant, novo;

		ant = nulo;
		p = raiz;
		while (p != nulo) {
			ant = p;

			if (dado < p.dado)
				p = p.esq;
			else if (dado > p.dado)
				p = p.dir;
			else if (dado == p.dado)
				return;
		}

		novo = new No(dado);
		novo.pai = ant;
		novo.esq = novo.dir = nulo;
		novo.cor = Cor.vermelho;

		if (raiz == nulo)
			raiz = novo;
		else if (dado < ant.dado) {
			ant.esq = novo;
		} else {
			ant.dir = novo;
		}

		InsRestaurarPropriedadeRN(novo);
	}

	private void InsRestaurarPropriedadeRN(No x) {
		No y;

		while (x.pai.cor == Cor.vermelho) {
			if (x.pai == x.pai.pai.esq) { // pai de x é filho esquerdo
				y = x.pai.pai.dir;

				if (y.cor == Cor.vermelho) { // Caso 1: y é vermelho
					y.cor = Cor.preto;
					x.pai.cor = Cor.preto;
					x.pai.pai.cor = Cor.vermelho;
					x = x.pai.pai;
				} else { // Caso 2 ou 3: y é preto
					if (x.pai.dir == x) { // Caso 2: x é filho direito
						x = x.pai;
						rotacaoEsq(x);
					}

					x.pai.cor = Cor.preto; // Caso 3: x é filho esquerdo
					x.pai.pai.cor = Cor.vermelho;
					rotacaoDir(x.pai.pai);
				}
			} else { // pai de x é filho direito
				y = x.pai.pai.esq;
				if (y.cor == Cor.vermelho) { // Caso 1: y é vermelho
					y.cor = Cor.preto;
					x.pai.cor = Cor.preto;
					x.pai.pai.cor = Cor.vermelho;
					x = x.pai.pai;
				} else {
					if (x.pai.esq == x) { // Caso 2: simetrico x é filho
											// esquerdo
						x = x.pai;
						rotacaoDir(x);
					}

					x.pai.cor = Cor.preto; // Caso 3: simetrico x é filho
											// direito
					x.pai.pai.cor = Cor.vermelho;
					rotacaoEsq(x.pai.pai);
				}
			}
		}
		raiz.cor = Cor.preto;
	}

}
