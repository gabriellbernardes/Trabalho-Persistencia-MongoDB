package model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;

import java.util.Date;

@Entity
public class Pesquisador extends Funcionario {

    private String atuacao;

    public Pesquisador() {
    }

    public Pesquisador(String nome, String sexo, Date aniversario, Double salario,
                       Departamento departamento, Endereco endereco, String atuacao) {
        super(nome, sexo, aniversario, salario, departamento, endereco);
        this.atuacao = atuacao;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }
}
