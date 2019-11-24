package dao;

import model.Departamento;
import model.Funcionario;
import model.Projeto;
import org.mongodb.morphia.Datastore;

import java.util.List;

public interface DepartamentoDAO extends GenericDAO<Departamento> {
    List<Departamento> findAll();
    Departamento findDep(int numero, String nome);



}
