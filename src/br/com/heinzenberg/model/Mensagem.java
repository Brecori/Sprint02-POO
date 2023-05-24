package br.com.heinzenberg.model;

import java.time.LocalDate;

public class Mensagem {

    private Tipo_ESG tipoEsg;
    private String mensagem;
    private LocalDate data;
    private Regiao regiao;
    private String motivo;
    private Funcionario funcionario;
    private Produto produto;

    public enum Tipo_ESG {
        SOCIAL, AMBIENTAL, GOVERNANCA;
    }

    public Tipo_ESG getTipoEsg() {
        return tipoEsg;
    }

    @Override
    public String toString() {
        return "Responsável: " + funcionario.getNome() + "\n" +
                "Motivo: " + motivo + "\n" +
                "Tipo Esg: " + tipoEsg + "\n" +
                "Data: " + data + "\n" +
                "Regiao: " + regiao.getPais() + "\n" +
                "Mensagem: " + mensagem + "\n";
    }

    public void setTipoEsg(Tipo_ESG tipoEsg) {
        this.tipoEsg = tipoEsg;
    }

    public Mensagem() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
