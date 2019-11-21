package dao;

import model.Funcionario;
import model.Pesquisador;

import java.util.List;

public interface FuncionarioDAO<T> extends GenericDAO<T> {
    List<Funcionario> findByNome(String nome, Class<T> tClass);
    List<Funcionario> SalarioMaiorQ(Double salario, Class<T> tClass);

}
