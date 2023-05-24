package br.com.heinzenberg.model;

public class Produto {
    private int sku;
    private String marca;

    public Produto(int sku, String marca) {
        this.sku = sku;
        this.marca = marca;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
