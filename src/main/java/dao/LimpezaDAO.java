package dao;

import model.Departamento;
import model.Limpeza;

import java.util.List;

public interface LimpezaDAO extends FuncionarioDAO<Limpeza> {
     List<Limpeza> findByCargo(String cargo);
     List<Limpeza> JornadaLimite(int horas);
     List<Limpeza> SupervisorList(Limpeza l);
}

