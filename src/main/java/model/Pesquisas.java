package model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Pesquisas {

    @Id
    private ObjectId id;

    @Reference
    private Projeto projeto;

    @Reference
    private Pesquisador pesquisador;

    private Integer horas;

    public Pesquisas() {
    }

    public Pesquisas(Projeto projeto, Pesquisador pesquisador, Integer horas) {
        this.id = new ObjectId();
        this.projeto = projeto;
        this.pesquisador = pesquisador;
        this.horas = horas;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Pesquisador getPesquisador() {
        return pesquisador;
    }

    public void setPesquisador(Pesquisador pesquisador) {
        this.pesquisador = pesquisador;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Pesquisas{" +
                "id=" + id +
                ", projeto=" + projeto +
                ", pesquisador=" + pesquisador +
                ", horas=" + horas +
                '}';
    }
}
