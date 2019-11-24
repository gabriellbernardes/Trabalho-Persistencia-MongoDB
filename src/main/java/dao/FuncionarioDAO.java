package dao;

import model.Dependente;
import model.Funcionario;
import org.bson.types.ObjectId;


import java.util.List;

public interface FuncionarioDAO<T> extends GenericDAO<T> {
    Funcionario findByNome(String nome, Class<T> tClass);
    List<Funcionario> SalarioMaiorQ(Double salario, Class<T> tClass);
    Dependente AddDependente();


    }
