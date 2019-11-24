package menu;

import dao.DepartamentoDAO;
import dao.SecretarioDAO;
import dao.morphia.DepartamentoMorphiaDAO;
import dao.morphia.SecretarioMorphiaDAO;
import model.Departamento;
import model.Endereco;;
import model.Secretario;
import morphia.MorphiaUtil;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class CrudSec {
    private Secretario sec;
    private  DepartamentoDAO depDao = new DepartamentoMorphiaDAO();
    private final SecretarioDAO secDao = new SecretarioMorphiaDAO();
    public CrudSec() {
    }

    public void AddSec() throws ParseException {
        Secretario secretario = LoginDialog();
        if(secretario == null){
            JOptionPane.showMessageDialog(null, "Erro !!\nDepartamento Não existe");
            return;
        }
        sec = MorphiaUtil.getDatastore().createQuery(Secretario.class).field("nome")
                .contains(secretario.getNome())
                .field("_id")
                .equal(secretario.getId())
                .get();

        if(sec==null) {
            secDao.save(secretario);
            JOptionPane.showMessageDialog(null, "Adicionado!!");
        }else {
            JOptionPane.showMessageDialog(null, "Erro!!\nSecretario já existe");
        }
    }
    public Secretario LoginDialog() throws ParseException {
        JLabel title = new JLabel("Cadastro Secretario");
        JTextField nome = new JTextField();
        JTextField sexo = new JTextField();
        JTextField aniversario = new JTextField();
        JTextField salario = new JTextField();
        JTextField lagradouro = new JTextField();
        JTextField numero = new JTextField();
        JTextField complemento = new JTextField();
        JTextField bairro = new JTextField();
        JTextField cidade = new JTextField();
        JTextField escolaridade = new JTextField();
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
                new JLabel("Escolaridade"),
                escolaridade,
        };
        JOptionPane.showMessageDialog(null, inputs, "Cadastro", JOptionPane.PLAIN_MESSAGE);
        Date c = new Date(aniversario.getText());
        Endereco end = new Endereco(lagradouro.getText()
                ,Integer.parseInt(numero.getText()),complemento.getText(),
                bairro.getText(),cidade.getText());

        Departamento dep = depDao.findDep(Integer.parseInt(numDep.getText()), nomDep.getText());
        if(dep == null)return null;
        sec = new Secretario(nome.getText(),sexo.getText(), c ,Double.parseDouble(salario.getText()),dep
                ,end,escolaridade.getText());
        sec.addDependente(secDao.AddDependente());
        return sec;
    }

    public void UpdateSec(){
        Query<Secretario> query = MorphiaUtil.getDatastore().createQuery(Secretario.class).
                field("nome").contains(JOptionPane.showInputDialog("Nome"))
                .field("escolaridade").contains(JOptionPane.showInputDialog("Escolaridade"));

        sec =  query.get();

        boolean a = (sec != null);
        JOptionPane.showMessageDialog(null, a ?  sec:"Nenhum Secretario encontrado");

        if(a) {
            UpdateOperations<Secretario> updates = MorphiaUtil.getDatastore().createUpdateOperations(Secretario.class)
                    .set(JOptionPane.showInputDialog("Campo a ser atualizado"), JOptionPane.showInputDialog("Preencha"));
            MorphiaUtil.getDatastore().update(query, updates);
        }else{
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar!!");
            return;
        }
    }
    public  void DeleteSec() {
        sec = MorphiaUtil.getDatastore().createQuery(Secretario.class).field("nome")
                .contains(JOptionPane.showInputDialog("Nome"))
                .field("escolaridade")
                .contains(JOptionPane.showInputDialog("Escolaridade"))
                .get();
        if (sec != null) {

            Query<Secretario> query = MorphiaUtil.getDatastore().createQuery(Secretario.class)
                    .field("nome").contains(sec.getNome()).field("escolaridade").contains(sec.getEscolaridade());

            MorphiaUtil.getDatastore().delete(query);
            JOptionPane.showMessageDialog(null,"Apagado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null, "Erro Secretario não existe!!");
        }

    }
    public void FindByEscolaridade(String escolaridade){
        List<Secretario> pesqs= secDao.findByEscolaridade(escolaridade);
        StringBuilder listagem = new StringBuilder();
        for(Secretario s: pesqs) {
            listagem.append(s).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Vazio" : listagem);
    }
}