package dao;

import factory.ConnectionFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Certificado;

public class CertificadoDAO {

    private Connection connection;

    String id;
    String nome_curso;
    String qtd_horas;
    String tipo;
    String anexo;
    String aluno;

    public CertificadoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Certificado certificado) {
        String sql = "INSERT INTO tab_certificados(aluno, nome_curso, qtd_horas, tipo, anexo) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, certificado.getAluno());
            stmt.setString(2, certificado.getNome_curso());
            stmt.setString(3, certificado.getQtd_horas());
            stmt.setString(4, certificado.getTipo());
            stmt.setString(5, certificado.getAnexo());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void delete(Certificado certificado) {
        try {

            Connection connection = new ConnectionFactory().getConnection();
            String sql = "delete from tab_certificados where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, certificado.getId());
            stmt.execute();
            stmt.close();
            connection.close();

            stmt.close();
            connection.close();

        } catch (SQLException e1) {

            // TODO Auto-generated catch block
            e1.printStackTrace();

        }
    }
}
