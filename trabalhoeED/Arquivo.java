package trabalhoed;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class Arquivo {

    private String texto;
    private final String nome;
    private Formatter saida;

    Arquivo() {
        this.nome = "resultado.txt";
    }

    public void criaArquivo(ListaConfiguracao lista) {
        try {
            this.saida = new Formatter(this.nome);
            Configuracao aux = lista.getInicio();
            this.saida.format("Resultados: "  + System.getProperty("line.separator") + System.getProperty("line.separator"));
            while (aux != null) {
                this.saida.format(aux.carregaResultado(texto));
                this.saida.format("\n");
                this.saida.format("\n");
                aux = aux.getProx();
            }
            saida.close();

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Erro ao criar o arquivo." + fileNotFoundException.getMessage());
            System.exit(-1);
        }
    }
}
