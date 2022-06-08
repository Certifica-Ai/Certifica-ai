package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno;

public class AlunoDAO {

    private Connection connection;
    String id;
    String ra;
    String senha;
    String email;
    String nome;
    String semestre;
    String horas;
    String curso_aluno;
    String curso;

    public AlunoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Aluno aluno) {
        String sql = "INSERT INTO tab_alunos(ra, nome, email, curso_aluno, semestre, senha ) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getRa());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getCurso_aluno());
            stmt.setString(5, aluno.getSemestre());
            stmt.setString(6, aluno.getSenha());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void delete(Aluno aluno) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "delete from tab_alunos where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getId());
            stmt.execute();
            stmt.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "'Id " + aluno.getId() + " '" + " Excluido com sucesso!");

            stmt.close();
            connection.close();

        } catch (SQLException e1) {

            // TODO Auto-generated catch block
            e1.printStackTrace();

        }
    }

    public void select(Aluno aluno) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select * from tab_alunos where id = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                aluno.setId(rs.getString("id"));
                aluno.setRa(rs.getString("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setHoras(rs.getString("horas"));
                aluno.setCurso_aluno(rs.getString("curso_aluno"));
                aluno.setSemestre(rs.getString("semestre"));
                aluno.setSenha(rs.getString("senha"));

            }
            rs.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void selectMedia(Aluno aluno) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "select AVG(horas > 100) FROM tab_alunos ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getHoras());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                aluno.setHoras(rs.getString("horas"));

            }
            rs.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void update(Aluno aluno) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "update tab_alunos set nome=?, email=?, curso_aluno=?, semestre=?, senha = ? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getCurso_aluno());
            stmt.setString(4, aluno.getSemestre());
            stmt.setString(5, aluno.getSenha());
            stmt.setString(6, aluno.getId());

            stmt.execute();
            stmt.close();
            connection.close();

            JOptionPane.showMessageDialog(null, "' " + aluno.getNome() + " '" + " Atualizado com sucesso!");

            stmt.close();
            connection.close();

            //limpa os campos
        } catch (SQLException e1) {

            e1.printStackTrace();

        }

    }

    public void updateHoras(Aluno aluno) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "update tab_alunos set horas = horas + ? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getHoras());
            stmt.setString(2, aluno.getId());

            stmt.execute();
            stmt.close();
            connection.close();

            JOptionPane.showMessageDialog(null, "'Id " + aluno.getId() + " '" + " Atualizado com sucesso!");

            stmt.close();
            connection.close();

            //limpa os campos
        } catch (SQLException e1) {

            e1.printStackTrace();

        }

    }
}
