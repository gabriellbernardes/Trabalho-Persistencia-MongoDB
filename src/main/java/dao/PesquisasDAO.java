package dao;


import model.Pesquisador;
import model.Pesquisas;
import model.Projeto;

import java.util.List;

public interface PesquisasDAO extends GenericDAO<Pesquisas> {
    List<Pesquisas> findByHoras(int horas);
    List<Pesquisas> findByProjeto(Projeto p);
    List<Pesquisas> findByPesquisador(Pesquisador p);

}
