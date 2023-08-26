package br.com.heinzenberg.controller.dao;

import br.com.heinzenberg.controller.conexao.Conexao;
import br.com.heinzenberg.model.Mensagem;

import java.sql.*;

public class MensagemDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private Conexao conexao;

    public MensagemDAO() {
        conexao = new Conexao();
    }

    public void inserir(Mensagem mensagem) {
        sql = "insert into tb_dado(id_dado, pais, qtd_comentario, data, feedback, tb_produto_sku, tb_do_tb_do_id) values (?,?,?,?,?,?,?)";

        try(Connection connection = conexao.conectar()) {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, mensagem.getId());
            ps.setString(2, mensagem.getPais());
            ps.setInt(3,mensagem.getQtd());
            ps.setDate(4, (Date) mensagem.getData());
            ps.setString(5,mensagem.getFeedback());
            ps.setInt(6,mensagem.getProduto().getSku());
            ps.setInt(7,mensagem.getObjetivo().getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
