package dao;

import model.Departamento;
import model.Funcionario;
import model.Projeto;
import org.mongodb.morphia.Datastore;

import java.util.List;

public interface DepartamentoDAO extends GenericDAO<Departamento> {
    List<Departamento> findByNome(String nome);
    Departamento findByNumero(int numero);



}
