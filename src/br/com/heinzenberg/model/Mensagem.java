package br.com.heinzenberg.model;

import java.time.LocalDate;
import java.util.Date;

public class Mensagem {
    private int id;
    private String pais;
    private int qtd;
    private Date data;
    private String feedback;
    private Produto produto;
    private Objetivo objetivo;

    public Mensagem(int id, String pais, int qtd, Date data, String feedback, Produto produto, Objetivo objetivo) {
        this.id = id;
        this.pais = pais;
        this.qtd = qtd;
        this.data = data;
        this.feedback = feedback;
        this.produto = produto;
        this.objetivo = objetivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
}
