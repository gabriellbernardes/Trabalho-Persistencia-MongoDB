package model;


import org.bson.types.ObjectId;

import java.util.Date;

public class Secretario extends Funcionario {

    private String escolaridade;

    public Secretario() {
    }

    public Secretario(String nome, String sexo, Date aniversario, Double salario,
                      Departamento departamento, Endereco endereco, String escolaridade) {
        super(nome, sexo, aniversario, salario, departamento, endereco);
        this.escolaridade = escolaridade;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    @Override
    public String toString() {
        return "Secretario{" +
                super.toString() +
                "escolaridade='" + escolaridade + '\'' +
                '}';
    }
}
