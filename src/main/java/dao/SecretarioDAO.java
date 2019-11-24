package dao;



import model.Secretario;

import java.util.List;

public interface SecretarioDAO extends FuncionarioDAO<Secretario> {
    List<Secretario> findByEscolaridade(String escolaridade);
}
