/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Coordenador;

/**
 *
 * @author Sandro V Vieira
 */
public class CoordenadorDAO {

    private Connection connection;
    String id;
    String login;
    String senha;
    String nome;
    String turno;
    String email;
    String curso_coor;
    String curso;

    public CoordenadorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Coordenador coor) {
        String sql = "INSERT INTO tab_coordenador(nome, email, curso_coor, turno, login, senha ) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, coor.getNome());
            stmt.setString(2, coor.getEmail());
            stmt.setString(3, coor.getCurso_coor());
            stmt.setString(4, coor.getTurno());
            stmt.setString(5, coor.getLogin());
            stmt.setString(6, coor.getSenha());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void delete(Coordenador coor) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "delete from tab_coordenador where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, coor.getId());
            stmt.execute();
            stmt.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "'Id " + coor.getId() + " '" + " excluído com sucesso!");

        } catch (SQLException e1) {

            // TODO Auto-generated catch block
            e1.printStackTrace();

        }
    }

    public void select(Coordenador coor) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from tab_coordenador where id = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, coor.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                coor.setId(rs.getString("id"));
                coor.setNome(rs.getString("nome"));
                coor.setEmail(rs.getString("email"));
                coor.setCurso_coor(rs.getString("curso_coor"));
                coor.setTurno(rs.getString("turno"));
                coor.setLogin(rs.getString("login"));
                coor.setSenha(rs.getString("senha"));

            }
            rs.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void update(Coordenador coor) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "update tab_coordenador set nome=?, email=?, curso_coor=?, turno=?, login=?, senha=? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, coor.getNome());
            stmt.setString(2, coor.getEmail());
            stmt.setString(3, coor.getCurso_coor());
            stmt.setString(4, coor.getTurno());
            stmt.setString(5, coor.getLogin());
            stmt.setString(6, coor.getSenha());
            stmt.setString(7, coor.getId());

            stmt.execute();
            stmt.close();
            connection.close();

            JOptionPane.showMessageDialog(null, "' " + coor.getNome() + " '" + " Atualizado com sucesso!");

            stmt.close();
            connection.close();

            //limpa os campos
        } catch (SQLException e1) {

            e1.printStackTrace();

        }

    }
}
