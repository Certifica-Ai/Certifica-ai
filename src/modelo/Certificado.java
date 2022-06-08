package modelo;

import java.io.File;

public class Certificado {

    String id;
    String nome_curso;
    String qtd_horas;
    String tipo;
    String anexo;
    String aluno;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getQtd_horas() {
        return qtd_horas;
    }

    public void setQtd_horas(String qtd_horas) {
        this.qtd_horas = qtd_horas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

}
