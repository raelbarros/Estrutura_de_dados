package trabalhoed;

import java.util.Random;

public class Item {

    private double preco;
    private Random rdn;
    private Item prox;

    public Item() {
        rdn = new Random();
        this.preco =  5 + rdn.nextDouble() * 45; // valores entre 5 a 50
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Item getProx() {
        return prox;
    }

    public void setProx(Item prox) {
        this.prox = prox;
    }

    public Random getRdn() {
        return rdn;
    }

    public void setRdn(Random rdn) {
        this.rdn = rdn;
    }
}
