package dao;

import model.Pesquisador;

import java.util.List;

public interface PesquisadorDAO extends FuncionarioDAO<Pesquisador> {
    List<Pesquisador> findByAtuacao(String atuacao);
}
