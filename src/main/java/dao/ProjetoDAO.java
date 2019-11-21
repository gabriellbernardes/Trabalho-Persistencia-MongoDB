package dao;

import model.Departamento;
import model.Projeto;

import java.util.List;

public interface ProjetoDAO extends GenericDAO<Projeto> {
    List<Projeto> findByNome(String nome);
    List<Departamento> findByNumeroDep(int numero);


}
