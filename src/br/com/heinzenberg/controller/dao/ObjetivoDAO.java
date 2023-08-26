package br.com.heinzenberg.controller.dao;

import br.com.heinzenberg.controller.conexao.Conexao;
import br.com.heinzenberg.model.Objetivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjetivoDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private Conexao conexao;

    public ObjetivoDAO() {
        conexao = new Conexao();
    }

    public void inserir(Objetivo objetivo) {
        sql = "insert into tb_objetivo(id_objetivo, nome, meta, tipo_esg, descricao) values (?,?,?,?,?)";

        try (Connection connection = conexao.conectar()) {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, objetivo.getId());
            ps.setString(2,objetivo.getNome());
            ps.setDouble(3, objetivo.getMeta());
            ps.setInt(4, objetivo.getTipoEsg());
            ps.setString(5, objetivo.getDescricao());
            ps.execute();
            ps.close();
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
}
