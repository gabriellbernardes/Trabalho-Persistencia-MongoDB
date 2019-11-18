package model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

@Entity
public class Projeto {

    @Id
    private ObjectId id;

    private String nome;

    private Integer numero;

    private Date dataInicio;

    private Date dataFim;

    @Reference
    private Departamento departamento;

    public Projeto() {
    }

    public Projeto(String nome, Integer numero, Date dataInicio, Date dataFim, Departamento departamento) {
        this.id = new ObjectId();
        this.nome = nome;
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.departamento = departamento;
    }

    public ObjectId getId() {
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numero=" + numero +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", departamento=" + departamento +
                '}';
    }
}
