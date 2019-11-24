package menu;


import javax.swing.JOptionPane;
import java.text.ParseException;

public class Menu {
    public Menu() {
    }

    public void menu() throws ParseException {
        CrudDep MDep = new CrudDep();
        CrudProj MProj = new CrudProj();
        CrudPesq MPesq = new CrudPesq();
        CrudLimp MLimp = new CrudLimp();
        CrudSec MSec = new CrudSec();
        CrudPesquisas Mpesquisas = new CrudPesquisas();

        String menu = "Escolha uma opção:\n1 - Menu Inserir \n2 - Menu Remover \n3 - Consultas\n4 - Update\n5 - Sair";
        char opcao;
        do{
            opcao = JOptionPane.showInputDialog(menu).charAt(0);

            switch (opcao) {
                case '1': // inserir
                    char opcaob;
                    String submenu = "Escolha uma opção:\n1 - Inserir Departamento\n2 - Inserir um Projeto \n3 - Inserir uma Pesquisa\n4 - Inserir um Secretario\n" +
                            "5 - Inserir Limpeza \n6 - Inserir Pesquisador \n7 - Inserir um Dependente\n8 - Inserir Um Supervisor De Limpezas\n9 - Sair";

                    do {
                        opcaob = JOptionPane.showInputDialog(submenu).charAt(0);
                        switch (opcaob) {
                            case '1':// Departamento
                                    MDep.AddDep();
                                break;
                            case '5': // Limpeza
                                    MLimp.AddLimp();
                                break;
                            case '6': // Pesquisador
                                    MPesq.AddPesq();
                                break;
                            case '4': // Secretario
                                    MSec.AddSec();
                                break;
                            case '3': // Pesquisa
                                    Mpesquisas.AddPesquisas();
                                break;
                            case '2': // Projeto
                                    MProj.AddDProj();
                                break;
                            case '9': // Sair
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida");
                                break;
                        }
                    }while (opcaob != '9');

                        break;

                case '2': // Remover
                    char opcaoc;
                    String submenu2 = "Escolha uma opção:\n1 - Remove Departamento\n2 - Remove um Projeto \n3 - Remove uma Pesquisa\n4 - Remove um Secretario\n" +
                            "5 - Remove Limpeza \n6 - Remove Pesquisador \n7 - Sair";

                    do {
                        opcaoc = JOptionPane.showInputDialog(submenu2).charAt(0);
                        switch (opcaoc) {
                            case '1':// Departamento
                                MDep.DeleteDep();
                                break;
                            case '5': // Limpeza
                                MLimp.DeleteLimp();
                                break;
                            case '6': // Pesquisador
                                MPesq.DeletePesq();
                                break;
                            case '4': // Secretario
                                MSec.DeleteSec();
                                break;
                            case '3': // Pesquisa
                                Mpesquisas.DeletePesquisas();
                                break;
                            case '2': // Projeto
                                MProj.DeleteProj();
                                break;
                            case '7': // Sair
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida");
                                break;
                        }
                    }while (opcaoc != '7');

                    break;
                case '3': // Consultas
                    char opcaod;
                    String submenu3 = "Escolha uma opção:\n1 - Lista Departamento\n2 - Lista Projeto Por Nome \n3 - Lista Pesquisas Por horas\n4 - Lista Secretario Por Escolaridade\n" +
                            "5 - Lista Supervisor \n6 - Lista Pesquisador Por Nome \n7 - Sair";

                    do {
                        opcaod = JOptionPane.showInputDialog(submenu3).charAt(0);
                        switch (opcaod) {
                            case '1':// Departamento
                                MDep.FindAll();
                                break;
                            case '5': // Limpeza
                                MLimp.listSupervisor();
                                break;
                            case '6': // Pesquisador
                                MPesq.FindByAtuacao(JOptionPane.showInputDialog("Atuação"));
                                break;
                            case '4': // Secretario
                                MSec.FindByEscolaridade(JOptionPane.showInputDialog("Escolaridade"));
                                break;
                            case '3': // Pesquisa
                                Mpesquisas.FindByHoras(Integer.parseInt(JOptionPane.showInputDialog("Horas")));
                                break;
                            case '2': // Projeto
                                MProj.FindByNome(JOptionPane.showInputDialog("Nome"));
                                break;
                            case '7': // Sair
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida");
                                break;
                        }
                    }while (opcaod != '7');
                    break;
                case '4': // Update
                    char opcaoe;
                    String submenu4 = "Escolha uma opção:\n1 - Departamento\n2 - Projeto \n3 - Pesquisas\n4 - Secretario \n" +
                            "5 - Limpeza \n6 - Pesquisador\n7 - Sair";

                    do {
                        opcaoe = JOptionPane.showInputDialog(submenu4).charAt(0);
                        switch (opcaoe) {
                            case '1':// Departamento
                                MDep.UpdateDep();
                                break;
                            case '5': // Limpeza
                                MLimp.UpdateLimp();
                                break;
                            case '6': // Pesquisador
                                MPesq.UpdatePesq();
                                break;
                            case '4': // Secretario
                                MSec.UpdateSec();
                                break;
                            case '3': // Pesquisa
                                Mpesquisas.UpdatePesquisas();
                                break;
                            case '2': // Projeto
                                MProj.UpdateProj();
                                break;
                            case '7': // Sair
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida");
                                break;
                        }
                    }while (opcaoe != '7');
                    break;
                case '5': // Sair
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                     break;
            }
        }while (opcao != '5');

    }
}
