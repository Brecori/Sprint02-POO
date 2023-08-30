package br.com.heinzenberg.controller.dao;

import br.com.heinzenberg.controller.conexao.Conexao;
import br.com.heinzenberg.model.Objetivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Erro ao inserir objetivo: " + e);
        }
    }

    public Objetivo pesquisar(int id) {
        Objetivo objetivo = null;
        sql = "select o.id_objetivo, o.nome, o.tipo_esg, o.descricao, o.meta from tb_objetivo o where o.id_objetivo = ?";

        try (Connection connection = conexao.conectar()) {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                double meta = rs.getDouble("meta");
                int tipoEsg = rs.getInt("tipo_esg");
                String descricao = rs.getString("descricao");
                objetivo = new Objetivo(id, nome, meta, tipoEsg, descricao);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar objetivo: " + e);
        }
        return objetivo;
    }

    public List<Objetivo> listar() {
        List<Objetivo> objetivos = new ArrayList<>();
        sql = "select o.id_objetivo, o.nome, o.tipo_esg, o.descricao, o.meta from tb_objetivo o order by id_objetivo";

        try (Connection connection = conexao.conectar()) {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_objetivo");
                String nome = rs.getString("nome");
                double meta = rs.getDouble("meta");
                int tipoEsg = rs.getInt("tipo_esg");
                String descricao = rs.getString("descricao");
                Objetivo objetivo = new Objetivo(id, nome, meta, tipoEsg, descricao);
                objetivos.add(objetivo);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar objetivos: " + e);
        }
        return objetivos;
    }

    public void remover(int id) {
        sql = "delete from tb_objetivo where id_objetivo = ?";
        try(Connection connection = conexao.conectar()) {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar objetivo: " + e);
        }
    }

    public void atualizar(Objetivo objetivo) {
        sql = "update tb_objetivo set nome = ?, meta = ?, tipo_esg = ?, descricao = ? where id_objetivo = ?";
        try(Connection connection = conexao.conectar()) {
            ps = connection.prepareStatement(sql);
            ps.setString(1, objetivo.getNome());
            ps.setDouble(2, objetivo.getMeta());
            ps.setInt(3, objetivo.getTipoEsg());
            ps.setString(4, objetivo.getDescricao());
            ps.setInt(5, objetivo.getId());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar objetivo: " + e);
        }
    }
}
