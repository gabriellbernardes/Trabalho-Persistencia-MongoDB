package model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public abstract class Funcionario {

    @Id
    private ObjectId id;

    private String nome;

    private String sexo;

    private Date aniversario;

    private Double salario;

    @Reference
    private Departamento departamento;

    @Embedded
    private Endereco endereco;

    @Embedded
    private List<Dependente> dependentes;

    public Funcionario() {
    }

    public Funcionario(String nome, String sexo, Date aniversario, Double salario,
                       Departamento departamento, Endereco endereco) {
        this.id = new ObjectId();
        ;
        this.nome = nome;
        this.sexo = sexo;
        this.aniversario = aniversario;
        this.salario = salario;
        this.departamento = departamento;
        this.endereco = endereco;
        this.dependentes = new ArrayList<Dependente>();
    }

    public Object getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public void addDependente(Dependente dependente) {
        if (this.dependentes != null)
            this.dependentes.add(dependente);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", aniversario=" + aniversario +
                ", salario=" + salario +
                ", departamento=" + departamento +
                ", endereco=" + endereco +
                ", dependentes=" + dependentes +
                '}';
    }
}