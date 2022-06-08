package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Cursos;

public class CursoDAO {

    private Connection connection;
    String id;
    String nome;
    String total_semestres;
    String total_horas;

    public CursoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Cursos cursos) {
        String sql = "INSERT INTO tab_cursos(nome, total_semestres, total_horas ) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cursos.getNome());
            stmt.setString(2, cursos.getTotal_semestres());
            stmt.setString(3, cursos.getTotal_horas());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void delete(Cursos cursos) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "delete from tab_cursos where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cursos.getId());
            stmt.execute();
            stmt.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "'Id " + cursos.getId()+ " '" + " excluído com sucesso!");

        } catch (SQLException e1) {

            // TODO Auto-generated catch block
            e1.printStackTrace();

        }
    }

    public void select(Cursos cursos) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from tab_cursos where id = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cursos.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cursos.setId(rs.getString("id"));
                cursos.setNome(rs.getString("nome"));
                cursos.setTotal_semestres(rs.getString("total_semestres"));
                cursos.setTotal_horas(rs.getString("total_horas"));

            }
            rs.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void update(Cursos cursos) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "update tab_cursos set nome=?, total_semestres=?, total_horas=? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cursos.getNome());
            stmt.setString(2, cursos.getTotal_semestres());
            stmt.setString(3, cursos.getTotal_horas());
            stmt.setString(4, cursos.getId());

            stmt.execute();
            stmt.close();
            connection.close();

            JOptionPane.showMessageDialog(null, "' " + cursos.getNome() + " '" + " Atualizado com sucesso!");

            stmt.close();
            connection.close();

            //limpa os campos
        } catch (SQLException e1) {

            e1.printStackTrace();

        }

    }
}
