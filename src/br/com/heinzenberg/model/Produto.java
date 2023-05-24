package br.com.heinzenberg.model;

public class Produto {
    private int sku;
    private String marcaProduto;

    public Produto(int sku, String marcaProduto) {
        this.sku = sku;
        this.marcaProduto = marcaProduto;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }
}
