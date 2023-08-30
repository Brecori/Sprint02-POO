package br.com.heinzenberg.model;

public class Produto {
    private int sku;
    private String nome;

    public Produto(int sku, String nome) {
        this.sku = sku;
        this.nome = nome;
    }

    public Produto(int sku) {
        this.sku = sku;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setMarcaProduto(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto: " + sku + "\n" +
                "Nome: " + nome + '\n';

    }
}
