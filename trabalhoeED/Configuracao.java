package trabalhoed;

import java.text.DecimalFormat;

public class Configuracao {
    
    DecimalFormat df = new DecimalFormat("R$: #,##0.00");

    private int horario;
    private double prob;

    private double saldo;
    private double lucro;
    private double custo;

    private int numeroDeCaixas;

    private int tempoMaximoDeEspera;

    private int numeroDeClientesAtendidos;
    private int numeroDeClientesNoCaixa;
    private int numeroDeClientesNaFila;
    private int totalDeClientes;

    private Configuracao prox;

    Configuracao(int horario, double prob, double saldo, int numeroDeCaixas, int tempoMaximoDeEspera, int numeroDeClientesAtendido, int numeroDeClienteNoCaixa, int numeroDeClienteNafila) {

        this.horario = horario;
        this.prob = prob;

        this.numeroDeCaixas = numeroDeCaixas;

        this.saldo = saldo;
        this.custo = this.numeroDeCaixas * 300.0;
        this.lucro = this.saldo - this.custo;

        this.tempoMaximoDeEspera = tempoMaximoDeEspera;

        this.numeroDeClientesAtendidos = numeroDeClientesAtendido;
        this.numeroDeClientesNoCaixa = numeroDeClienteNoCaixa;
        this.numeroDeClientesNaFila = numeroDeClienteNafila;

        this.totalDeClientes = this.numeroDeClientesAtendidos + this.numeroDeClientesNaFila + this.numeroDeClientesNoCaixa;

        this.prox = null;
    }

    public void infoConfiguracao() {
        System.out.println("Horario: " + getHorario() + " Horas." + " Probabilidade: " + getProb() +
                           "\n Clientes Atendidos: " + getNumeroDeClientesAtendidos() +
                           "\n Clientes no caixa: " + getNumeroDeClientesNoCaixa() +
                           "\n Clientes na fila: " + getNumeroDeClientesNaFila()  +
                           "\n Total de clientes: " + getTotalDeClientes() +
                           "\n Numero de Caixas ativo: " + getNumeroDeCaixas() +
                           "\n Tempo máximo de espera: " + getTempoMaximoDeEspera() +
                           "\n Saldo: " + df.format(getSaldo())  +
                           "\n Custo: " + df.format(getCusto()) + 
                           "\n Lucro: " + df.format(getLucro()) +
                           "\n ----------------------------------------------------------------------------------------------------------- ");
    }

    // Método de sobrecarga usado para mandar os dados para o arquivo. 
    public String carregaResultado(String texto) {
        texto = "Horario: " + String.valueOf(getHorario()) + " Horas." + " Probabilidade: " + String.valueOf(getProb()) + System.getProperty("line.separator") + System.getProperty("line.separator") +
                "Clientes Atendidos: " + String.valueOf(getNumeroDeClientesAtendidos()) + System.getProperty("line.separator") +
                "Clientes no caixa: " + String.valueOf(getNumeroDeClientesNoCaixa()) + System.getProperty("line.separator") +
                "Clientes na fila: " + String.valueOf(getNumeroDeClientesNaFila()) + System.getProperty("line.separator") +
                "Total de clientes: " + String.valueOf(getTotalDeClientes()) + System.getProperty("line.separator") +
                "Numero de Caixas ativo: " + String.valueOf(getNumeroDeCaixas()) + System.getProperty("line.separator") +
                "Tempo máximo de espera: " + getTempoMaximoDeEspera() + System.getProperty("line.separator") +
                "Saldo: " + String.valueOf(df.format(getSaldo())) + System.getProperty("line.separator") +
                "Custo: " + String.valueOf(df.format(getCusto())) + System.getProperty("line.separator") +
                "Lucro: " + String.valueOf(df.format(getLucro()) + System.getProperty("line.separator") +
                " ----------------------------------------------------------------------------------------------------------- " + System.getProperty("line.separator") + System.getProperty("line.separator"));

        return texto;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getNumeroDeCaixas() {
        return numeroDeCaixas;
    }

    public void setNumeroDeCaixas(int numeroDeCaixas) {
        this.numeroDeCaixas = numeroDeCaixas;
    }

    public int getTempoMaximoDeEspera() {
        return tempoMaximoDeEspera;
    }

    public void setTempoMaximoDeEspera(int tempoMaximoDeEspera) {
        this.tempoMaximoDeEspera = tempoMaximoDeEspera;
    }

    public int getNumeroDeClientesAtendidos() {
        return numeroDeClientesAtendidos;
    }

    public void setNumeroDeClientesAtendidos(int numeroDeClientesAtendidos) {
        this.numeroDeClientesAtendidos = numeroDeClientesAtendidos;
    }

    public int getNumeroDeClientesNoCaixa() {
        return numeroDeClientesNoCaixa;
    }

    public void setNumeroDeClientesNoCaixa(int numeroDeClientesNoCaixa) {
        this.numeroDeClientesNoCaixa = numeroDeClientesNoCaixa;
    }

    public int getNumeroDeClientesNaFila() {
        return numeroDeClientesNaFila;
    }

    public void setNumeroDeClientesNaFila(int numeroDeClientesNaFila) {
        this.numeroDeClientesNaFila = numeroDeClientesNaFila;
    }

    public int getTotalDeClientes() {
        return totalDeClientes;
    }

    public void setTotalDeClientes(int totalDeClientes) {
        this.totalDeClientes = totalDeClientes;
    }

    public Configuracao getProx() {
        return prox;
    }

    public void setProx(Configuracao prox) {
        this.prox = prox;
    }

}
