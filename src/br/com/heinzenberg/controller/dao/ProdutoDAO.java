package br.com.heinzenberg.controller.dao;

import br.com.heinzenberg.controller.conexao.Conexao;
import br.com.heinzenberg.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private Conexao conexao;

    public ProdutoDAO() {
        conexao = new Conexao();
    }

    public void inserir(Produto produto) {
        sql = "insert into tb_produto(sku, nome) values (?,?)";

        try(Connection connection = conexao.conectar()) {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getSku());
            ps.setString(2, produto.getNome());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
