package menu;

import dao.DepartamentoDAO;
import dao.PesquisadorDAO;
import dao.morphia.DepartamentoMorphiaDAO;
import dao.morphia.PesquisadorMorphiaDAO;
import model.Departamento;
import model.Endereco;
import model.Pesquisador;
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

public class CrudPesq {
    private Pesquisador pesq;
    private DepartamentoDAO depDao = new DepartamentoMorphiaDAO();
    private final PesquisadorDAO pesqDao = new PesquisadorMorphiaDAO();
    public CrudPesq() {
    }

    public void AddPesq() throws ParseException {
        Pesquisador Pesquisador = LoginDialog();
        if(Pesquisador == null){
            JOptionPane.showMessageDialog(null, "Erro !!\nDepartamento Não existe");
            return;
        }
        pesq = MorphiaUtil.getDatastore().createQuery(Pesquisador.class).field("nome")
                .contains(Pesquisador.getNome())
                .field("atuacao")
                .contains(Pesquisador.getAtuacao())
                .get();

        if(pesq==null) {
            pesqDao.save(Pesquisador);
            JOptionPane.showMessageDialog(null, "Adicionado!!");
        }else {
            JOptionPane.showMessageDialog(null, "Erro!!\nPesquisador já existe");
        }
    }

    public Pesquisador LoginDialog() throws ParseException {
        JLabel title = new JLabel("Cadastro Pesquisador");
        JTextField nome = new JTextField();
        JTextField sexo = new JTextField();
        JTextField aniversario = new JTextField();
        JTextField salario = new JTextField();
        JTextField lagradouro = new JTextField();
        JTextField numero = new JTextField();
        JTextField complemento = new JTextField();
        JTextField bairro = new JTextField();
        JTextField cidade = new JTextField();
        JTextField atuacao = new JTextField();
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
                new JLabel("Atuacao"),
                atuacao,
        };
        JOptionPane.showMessageDialog(null, inputs, "Cadastro", JOptionPane.PLAIN_MESSAGE);
        Date c = new Date(aniversario.getText());

        Endereco end = new Endereco(lagradouro.getText()
                ,Integer.parseInt(numero.getText()),complemento.getText(),
                bairro.getText(),cidade.getText());

        Departamento dep = depDao.findDep(Integer.parseInt(numDep.getText()), nomDep.getText());
        if(dep == null)return null;

        pesq = new Pesquisador(nome.getText(),sexo.getText(), c ,Double.parseDouble(salario.getText()),dep
                ,end,atuacao.getText());
        pesq.addDependente(pesqDao.AddDependente());
        return pesq;
    }

    public void UpdatePesq(){

        Query<Pesquisador> query = MorphiaUtil.getDatastore().createQuery(Pesquisador.class).
                field("nome").contains(JOptionPane.showInputDialog("Nome"))
                .field("atuacao").contains(JOptionPane.showInputDialog("Atuacao"));

        pesq =  query.get();

        boolean a = (pesq != null);
        JOptionPane.showMessageDialog(null, a ?  pesq:"Pesquisador nao encontrado");

        if(a) {
            UpdateOperations<Pesquisador> updates = MorphiaUtil.getDatastore().createUpdateOperations(Pesquisador.class)
                    .set(JOptionPane.showInputDialog("Campo a ser atualizado"), JOptionPane.showInputDialog("Preencha"));
            MorphiaUtil.getDatastore().update(query, updates);
        }else{
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar!!");
            return;
        }
    }
    public  void DeletePesq() {
        pesq = MorphiaUtil.getDatastore().createQuery(Pesquisador.class).field("nome")
                .contains(JOptionPane.showInputDialog("Nome"))
                .field("atuacao")
                .contains(JOptionPane.showInputDialog("Atuacao"))
                .get();
        if (pesq != null) {
            Query<Pesquisador> query = MorphiaUtil.getDatastore().createQuery(Pesquisador.class)
                    .field("nome").contains(pesq.getNome()).field("atuacao").contains(pesq.getAtuacao());
            MorphiaUtil.getDatastore().delete(query);
            JOptionPane.showMessageDialog(null,  "Apagado com sucesso" );
        }else{
            JOptionPane.showMessageDialog(null, "Erro Pesquisador não existe!!");
        }
    }
    public void FindByAtuacao(String atuacao){
        List<Pesquisador> pesqs= pesqDao.findByAtuacao(atuacao);
        StringBuilder listagem = new StringBuilder();
        for(Pesquisador d: pesqs) {
            listagem.append(d).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Vazio" : listagem);
    }
}
