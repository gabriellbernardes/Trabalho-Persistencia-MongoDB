package menu;

import dao.DepartamentoDAO;
import dao.LimpezaDAO;
import dao.morphia.DepartamentoMorphiaDAO;
import dao.morphia.LimpezaMorphiaDAO;
import model.*;
import morphia.MorphiaUtil;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComponent;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class CrudLimp {
    private static Limpeza limp;
    private static final DepartamentoDAO depDao = new DepartamentoMorphiaDAO();
    private static final LimpezaDAO limpDao = new LimpezaMorphiaDAO();

    public CrudLimp() {
    }

    public void AddLimp() throws ParseException {
        Limpeza limpeza = LoginDialog();
        if(limpeza == null){
            JOptionPane.showMessageDialog(null, "Erro !!\nDepartamento Não existe");
            return;
        }

        limp = MorphiaUtil.getDatastore().createQuery(Limpeza.class).field("nome")
                .contains(limpeza.getNome())
                .field("cargo")
                .contains(limpeza.getCargo())
                .get();

        if(limp==null) {
            limpDao.save(limpeza);
            JOptionPane.showMessageDialog(null, "Adicionado!!");
        }else {
            JOptionPane.showMessageDialog(null, "Erro!!\nLimpeza já existe");
        }
    }

    public static Limpeza LoginDialog() throws ParseException {
        JLabel title = new JLabel("Cadastro Limpeza");
        JTextField nome = new JTextField();
        JTextField sexo = new JTextField();
        JTextField aniversario = new JTextField();
        JTextField salario = new JTextField();
        JTextField lagradouro = new JTextField();
        JTextField numero = new JTextField();
        JTextField complemento = new JTextField();
        JTextField bairro = new JTextField();
        JTextField cidade = new JTextField();
        JTextField cargo = new JTextField();
        JTextField jornada = new JTextField();
        JTextField numDep = new JTextField();
        JTextField nomDep = new JTextField();

        final JComponent[] inputs = new JComponent[] {
                title,
                new JLabel("Nome"),
                nome,
                new JLabel("Sexo"),
                sexo,
                new JLabel("Aniversario"),
                aniversario,
                new JLabel("Salario"),
                salario,
                new JLabel("Lagradouro"),
                lagradouro,
                new JLabel("Numero da Casa"),
                numero,
                new JLabel("Complemento"),
                complemento,
                new JLabel("Bairro"),
                bairro,
                new JLabel("Cidade"),
                cidade,
                new JLabel("Nome Departamento"),
                nomDep,
                new JLabel("Numero Departamento"),
                numDep,
                new JLabel("Jornada"),
                jornada,
                new JLabel("Cargo"),
                cargo

        };
        JOptionPane.showMessageDialog(null, inputs, "Cadastro", JOptionPane.PLAIN_MESSAGE);
        Date c = new Date(aniversario.getText());

        Endereco end = new Endereco(lagradouro.getText()
                ,Integer.parseInt(numero.getText()),complemento.getText(),
                bairro.getText(),cidade.getText());

        Departamento dep = depDao.findDep(Integer.parseInt(numDep.getText()), nomDep.getText());
        if(dep == null)return null;
        limp = new Limpeza(nome.getText(),sexo.getText(), c ,Double.parseDouble(salario.getText()),dep
                ,end,cargo.getText(),Integer.parseInt(jornada.getText()), null);
        limp.addDependente(limpDao.AddDependente());
        return limp;
    }

    public void UpdateLimp(){
        Query<Limpeza> query = MorphiaUtil.getDatastore().createQuery(Limpeza.class).
                field("nome").contains(JOptionPane.showInputDialog("Nome"))
                .field("cargo").contains(JOptionPane.showInputDialog("Cargo"));

        limp =  query.get();
        boolean a = (limp != null);
        JOptionPane.showMessageDialog(null, a ?  limp:"Nenhum Limpeza encontrado");

        if(a) {
            UpdateOperations<Limpeza> updates = MorphiaUtil.getDatastore().createUpdateOperations(Limpeza.class)
                    .set(JOptionPane.showInputDialog("Campo a ser atualizado"), JOptionPane.showInputDialog("Preencha"));
            MorphiaUtil.getDatastore().update(query, updates);
        }else{
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar!!");
            return;
        }
    }
    public  void DeleteLimp(){

        limp = MorphiaUtil.getDatastore().createQuery(Limpeza.class).field("nome")
                .contains(JOptionPane.showInputDialog("Nome"))
                .field("cargo")
                .contains(JOptionPane.showInputDialog("Cargo"))
                .get();
        if(limp!=null) {
            Query<Limpeza> query = MorphiaUtil.getDatastore().createQuery(Limpeza.class).field("nome").contains(limp.getNome());
            MorphiaUtil.getDatastore().delete(query);
            JOptionPane.showMessageDialog(null, "Apagado com sucesso");
        }else {
            JOptionPane.showMessageDialog(null, "Erro!!\n Limpeza não existe");
            return;
        }


    }
    public  void SetSupervisor(Limpeza l, Limpeza supervisor){
        Query<Limpeza> query = MorphiaUtil.getDatastore().createQuery(Limpeza.class).
                field("_id").contains(l.getId().toString());

        UpdateOperations<Limpeza> updates = MorphiaUtil.getDatastore().createUpdateOperations(Limpeza.class)
                .addToSet("supervisor", supervisor);
        MorphiaUtil.getDatastore().update(query, updates);
    }

    public void listSupervisor(){
        List<Limpeza> limpezas= limpDao.SupervisorList();
        StringBuilder listagem = new StringBuilder();
        for(Limpeza d: limpezas) {
            listagem.append(d).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Vazio" : listagem);
    }



}
