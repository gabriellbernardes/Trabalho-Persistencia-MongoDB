package dao.morphia;

import dao.FuncionarioDAO;
import model.Funcionario;
import morphia.MorphiaUtil;

import java.util.List;

public class FuncionarioMorphiaDAO<T> extends GenericMorphiaDAO<T> implements FuncionarioDAO<T> {

    public FuncionarioMorphiaDAO(Class<T> persistenceClass) {
        super(persistenceClass);
    }
        @Override
       public List<Funcionario> findByNome(String nome, Class<T> tClass){
            List<Funcionario> funcs = (List<Funcionario>) MorphiaUtil.getDatastore().createQuery(tClass)
                    .field("nome")
                    .contains(nome).asList();
            return funcs;

        }

    @Override
    public List<Funcionario> SalarioMaiorQ(Double salario, Class<T> tClass) {
        List<Funcionario> funcs = (List<Funcionario>) MorphiaUtil.getDatastore().createQuery(tClass)
                .field("salario")
                .greaterThanOrEq(salario).asList();
        return funcs;

    }

    }


