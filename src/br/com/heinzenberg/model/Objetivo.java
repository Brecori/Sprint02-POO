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

    public Objetivo(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return  "Objetivo " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Tipo de Esg: " + esgNumberToString(tipoEsg) + "\n" +
                "Descricao: " + descricao + '\n' +
                "Meta: " + meta + "\n";
    }

    public String esgNumberToString(int tipoEsg) {
        switch (tipoEsg) {
            case 1:
                return "Social";
            case 2:
                return "Ambiental";
            case 3:
                return "Governanca";
            default:
                return "ESG invalido";
        }
    }
}
