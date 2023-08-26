package br.com.heinzenberg.model;


public class Objetivo {
    private int id;
    private String nome;
    private double meta;
    private int tipoEsg;
    private String descricao;


    public Objetivo(int id, String nome, double meta, int tipoEsg, String descricao) {
        this.id = id;
        this.nome = nome;
        this.meta = meta;
        this.tipoEsg = tipoEsg;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public int getTipoEsg() {
        return tipoEsg;
    }

    public void setTipoEsg(int tipoEsg) {
        this.tipoEsg = tipoEsg;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
