package model;

import org.mongodb.morphia.annotations.Embedded;

import java.util.Date;

@Embedded
public class Dependente {

    private String nome;

    private String sexo;

    private Date aniversario;

    private String grau;

    public Dependente() {
    }

    public Dependente(String nome, String sexo, Date aniversario, String grau) {
        this.nome = nome;
        this.sexo = sexo;
        this.aniversario = aniversario;
        this.grau = grau;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    @Override
    public String toString() {
        return "Dependente{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", aniversario=" + aniversario +
                ", grau='" + grau + '\'' +
                '}';
    }
}
