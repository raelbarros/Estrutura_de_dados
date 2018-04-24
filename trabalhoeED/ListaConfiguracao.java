package trabalhoed;

public class ListaConfiguracao {

    private Configuracao inicio;

    ListaConfiguracao() {
        this.inicio = null;
    }

    // Adiciona todas configuraçoes em que os clientes fiquem menos de dez minutos esperando.
    public void add(int horario, double prob, double saldo, int numeroDeCaixas, int tempoMaximoDeEspera, int numeroDeClientesAtendido, int numeroDeClienteNoCaixa, int numeroDeClienteNafila) {

        Configuracao aux = this.inicio;
        Configuracao ant = null;
        Configuracao novo = new Configuracao(horario, prob, saldo, numeroDeCaixas, tempoMaximoDeEspera, numeroDeClientesAtendido, numeroDeClienteNoCaixa, numeroDeClienteNafila);

        while (aux != null) {
            ant = aux;
            aux = aux.getProx();
        }

        if (ant != null) {
            ant.setProx(novo);
            novo.setProx(null);
        } else {
            novo.setProx(this.inicio);
            this.inicio = novo;
        }
    }

    private void add(Configuracao no, ListaConfiguracao lista) {
        Configuracao aux = lista.inicio;
        Configuracao ant = null;

        if (no != null) {
            Configuracao novo = new Configuracao(no.getHorario(), no.getProb(), no.getSaldo(), no.getNumeroDeCaixas(), no.getTempoMaximoDeEspera(), no.getNumeroDeClientesAtendidos(), no.getNumeroDeClientesNoCaixa(), no.getNumeroDeClientesNaFila());

            while (aux != null) {
                ant = aux;
                aux = aux.getProx();
            }

            if (ant != null) {
                ant.setProx(novo);
                novo.setProx(null);
            } else {
                novo.setProx(lista.inicio);
                lista.inicio = novo;
            }
        }
    }

    // Método retorna a lista com os resultados
    public ListaConfiguracao buscaResultados() {
        ListaConfiguracao resultados = new ListaConfiguracao();

        Configuracao aux = this.inicio;

        for (int cont = 8; cont <= 20; cont = cont + 2) {
            int menor = 21;
            Configuracao maior = null;

            while (aux != null && aux.getHorario() == cont) {
                if (aux.getNumeroDeCaixas() <= menor) {
                    menor = aux.getNumeroDeCaixas();
                    maior = aux;
                }
                aux = aux.getProx();
            }
            add(maior, resultados);
        }
        return resultados;
    }

    public void imprimi() {
        Configuracao aux = this.inicio;
        System.out.println("Resultados: \n");

        while (aux != null) {
            aux.infoConfiguracao();
            aux = aux.getProx();
        }
    }

    public Configuracao getInicio() {
        return inicio;
    }

    public void setInicio(Configuracao inicio) {
        this.inicio = inicio;
    }
}
