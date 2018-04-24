package trabalhoed;

public final class Simulacao {

    private final FilaCliente filaDeClientesAtendidos;
    private final FilaCliente filaDeEspera;
    private final Horario quadroDeHorario;
    private final ListaCaixa listaDeCaixas;
    private final ListaConfiguracao listaDeConfiguracoes;
    private ListaConfiguracao resultado;
    private final Arquivo arquivo;

    public Simulacao() {
        this.filaDeClientesAtendidos = new FilaCliente();
        this.filaDeEspera = new FilaCliente();
        this.quadroDeHorario = new Horario();
        this.listaDeCaixas = new ListaCaixa();
        this.listaDeConfiguracoes = new ListaConfiguracao();
        this.resultado = null;
        this.arquivo = new Arquivo();
        playStart();

    }

    // Método principal que roda a app.
    private void playStart() {
        try {
            for (int i = 0; i < 7; i++) {
                for (int j = 5; j <= 20; j++) {
                    instanciarCaixas(j); // instacia j caixas de 5 a 20
                    for (int k = 1; k <= 120; k++) {
                        simulaRodada(i);
                    }
                    verificarConfiguracao(i, j); // se a configuração respeitar o pré-requisitos ela é add na lista.
                    esvaziarFilasListas();
                }
            }

            buscaResultado(); // busca as melhores configurações para cada horário
            escritaDeArquivo(this.resultado); // escrevar os resultados no arquivo.
        } catch (UnsupportedOperationException e) {
            System.err.println("Erro ao criar a lista de caixas");
            System.exit(-1);
        }
    }

    // Método que inicializa lista com número de 5 a 20 de caixas
    private void instanciarCaixas(int j) {
        for (int i = 1; i <= j; i++) {
            try {
                this.listaDeCaixas.addNoComeco();
            } catch (java.lang.NullPointerException nullPointerException) {
                System.err.println(nullPointerException.getMessage());
                System.exit(-1);
            }
        }
    }

    // Método que simula a cada minuto entrada o fluxo de clientes.
    private void simulaRodada(int i) {
        addClientesNaFilaDeEspera(i);
        addNaFilaClientesAtendidos();
        addClientesNoCaixa();
        removeItensCliente();
        acrescentaTempoDeEspera();
    }

    // Método que adiciona clientes que já foram atendidos no caixa,  para fila clienteAtendidos
    private void addNaFilaClientesAtendidos() {
        FilaCliente fila = removeClientesDoCaixa();
        Cliente aux = fila.getInicio();

        while (aux != null) {
            this.filaDeClientesAtendidos.add(aux);
            aux = aux.getProx();
        }
    }

    // Método que remove os clientes que terminaram o atendimento ao caixa
    private FilaCliente removeClientesDoCaixa() {
        return this.listaDeCaixas.removeClienteDoCaixa(); // método retorna um fila com os clientes que acabaram de sair do caixa.
    }

    // Método que recebe filaClientesNaoAtendidos e envia para o caixa caso o caixa esteja livre
    private void addClientesNoCaixa() {
        this.listaDeCaixas.addClienteNoCaixa(filaDeEspera);
    }

    //Método responsavel por adicionar clientes na fila de espera dependendo da probabilidade do horario e o número randomico.
    private void addClientesNaFilaDeEspera(int i) {
        probClienteEntraNaFila(i);
    }

    // Remove itens que estão no topo da pilha de cada cliente da lista de caixa
    private void removeItensCliente() {
        this.listaDeCaixas.retiraItensTopo(); // método também recebe o valor do topp
    }

    // Método que acrescente + 1 ao tempo de espera dos clientes da fila
    private void acrescentaTempoDeEspera() {
        this.filaDeEspera.acrescentaTempoDeEspera();
    }

    // Adiciona cliente na fila dependendo da prob
    private void probClienteEntraNaFila(int i) {
        int numeroAleatorio = this.quadroDeHorario.calculaProbCliente(); // número de 1 a 10.
        int numeroProb = (int) (this.quadroDeHorario.tabela[i].getProb() * 10); // recebe a probilidade * 10
        if (numeroAleatorio <= numeroProb) {
            this.filaDeEspera.add();
        }
    }

    // Métodos para verificar configuração
    private void buscaResultado() {
        this.resultado = this.listaDeConfiguracoes.buscaResultados();
        this.resultado.imprimi();
    }

    // Método responsavel pela verificação se a configuração atinge os pre requisitos
    private void verificarConfiguracao(int i, int j) {
        if (verificaTempoDeEspera()) {
            this.listaDeConfiguracoes.add(this.quadroDeHorario.tabela[i].getHorario(), this.quadroDeHorario.tabela[i].getProb(), somaSaldo(), j, tempoMaximoDeEspera(), contFilaDeClientesAtendidos(), contListaCaixa(), contFilaDeEspera());
        }
    }

    // Método verifica o tempo de espera de cada cliente teve na fila.
    private boolean verificaTempoDeEspera() {
        Cliente aux = this.filaDeClientesAtendidos.getInicio();
        Cliente auxb = this.filaDeEspera.getInicio();
        Caixa cx = this.listaDeCaixas.getInicio();

        // Verifica  o tempo de espera dos clientes na fila de atendidos
        while (aux != null) {
            if (aux.getTempoDeEspera() >= 10) {
                return false;
            }
            aux = aux.getProx();
        }

        // verifica  o tempo de espera dos clientes nos caixas
        while (auxb != null) {
            if (auxb.getTempoDeEspera() >= 10) {
                return false;
            }
            auxb = auxb.getProx();
        }

        while (cx != null) {
            if (cx.getCliente() != null) { // verifica  o tempo de espera dos clientes na fila de espera
                if (cx.getCliente().getTempoDeEspera() >= 10) {
                    return false;
                }
            }
            cx = cx.getProx();
        }
        return true;
    }

    // Método que retorna a soma dos saldo dos caixas;
    private double somaSaldo() {
        return this.listaDeCaixas.somaSaldo();
    }

    // Retorna o tatal de clientes de cada configuração
    private int calculaNumeroTotalDeClientes() {
        Cliente aux1 = this.filaDeClientesAtendidos.getInicio();
        Cliente aux2 = this.filaDeEspera.getInicio();
        Cliente aux3 = this.listaDeCaixas.getInicio().getCliente();
        int cont = 0;

        while (aux1 != null) {
            cont++;
            aux1 = aux1.getProx();
        }

        while (aux2 != null) {
            cont++;
            aux2 = aux2.getProx();
        }

        while (aux3 != null) {
            cont++;
            aux3 = aux3.getProx();
        }
        return cont;
    }

    private int tempoMaximoDeEspera() {
        int max = 0;

        Cliente aux1 = this.filaDeClientesAtendidos.getInicio();
        Cliente aux2 = this.filaDeEspera.getInicio();
        Cliente aux3 = this.listaDeCaixas.getInicio().getCliente();

        while (aux1 != null) {
            if (max < aux1.getTempoDeEspera()) {
                max = aux1.getTempoDeEspera();
            }
            aux1 = aux1.getProx();
        }
        while (aux2 != null) {
            if (max < aux2.getTempoDeEspera()) {
                max = aux2.getTempoDeEspera();
            }
            aux2 = aux2.getProx();
        }
        while (aux3 != null) {
            if (max < aux3.getTempoDeEspera()) {
                max = aux3.getTempoDeEspera();
            }
            aux3 = aux3.getProx();
        }
        return max;
    }

    // Método de arquivo
    private void escritaDeArquivo(ListaConfiguracao lista) {
        this.arquivo.criaArquivo(lista);
    }

    // Métodos para esvaziar as estruturas
    private void esvaziarFilasListas() {
        esvaziaClientesAtendidos();
        esvaziaFilaDeEspera();
        esvaziaListaCaixa();
    }

    private void esvaziaClientesAtendidos() {
        this.filaDeClientesAtendidos.esvaziaFila();
    }

    private void esvaziaFilaDeEspera() {
        this.filaDeEspera.esvaziaFila();
    }

    private void esvaziaListaCaixa() {
        this.listaDeCaixas.esvaziaLista();
    }

    // Métodos de contagens
    private int contFilaDeClientesAtendidos() {
        return this.filaDeClientesAtendidos.contElement();
    }

    private int contFilaDeEspera() {
        return this.filaDeEspera.contElement();
    }

    private int contListaCaixa() {
        return this.listaDeCaixas.contElementos();
    }
}
