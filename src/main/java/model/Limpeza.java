package model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

@Entity
public class Limpeza extends Funcionario {

    private String cargo;

    private Integer jornada;

    @Reference
    private Funcionario supervisor;

    public Limpeza() {
    }

    public Limpeza(String nome, String sexo, Date aniversario, Double salario, Departamento departamento,
                   Endereco endereco, String cargo, Integer jornada, Funcionario supervisor) {
        super(nome, sexo, aniversario, salario, departamento, endereco);
        this.cargo = cargo;
        this.jornada = jornada;
        this.supervisor = supervisor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getJornada() {
        return jornada;
    }

    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }

    public Funcionario getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Funcionario supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Limpeza{" +
                "cargo='" + cargo + '\'' +
                ", jornada=" + jornada +
                ", supervisor=" + supervisor +
                '}';
    }
}
