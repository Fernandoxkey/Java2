package empresa;

import servico.HibernateUtil;
import telas.*;

import java.util.Scanner;

public class Login {
    private static final String LOGIN_PADRAO = "barbearia";
    private static final String SENHA_PADRAO = "barba123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de Servicos!");
        boolean tentarLogin = true;
        while (tentarLogin) {
            System.out.print("Login: ");
            String login = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (validarLogin(login, senha)) {
                exibirMenu(scanner);
                break;
            } else {
                System.out.println("Usuario ou senha invalidos. Deseja tentar novamente? [s/n]");
                var opcao = scanner.nextLine();
                if (!opcao.toLowerCase().equals("s")) {
                    tentarLogin = false;
                }
            }
        }
        HibernateUtil.fecharFectory();
    }

    private static void exibirMenu(Scanner scanner) {
        String opcao = null;
        do {
            System.out.println("-----------------------------------");
            System.out.println("Sistema de Gerenciamento");
            System.out.println("-----------------------------------");
            System.out.println("1 - Cadastro de Cliente");
            System.out.println("2 - Cadastro de Profissional");
            System.out.println("3 - Cadastro de Servicos");
            System.out.println("0 - Sair");
            System.out.println("-----------------------------------");
            System.out.println("Digite o Cadastro Selecionado:");
            opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    TelaCliente.executar(scanner);
                    break;
                case "2":
                    TelaProfissional.executar(scanner);
                    break;
                case "3":
                    TelaServicos.executar(scanner);
                    break;
                case "0":
                    System.out.println("Finalizando Sistema");
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }
        } while (opcao != "0");
    }

    private static boolean validarLogin(String login, String senha) {
        return login.equals(LOGIN_PADRAO) && senha.equals(SENHA_PADRAO);
    }


}
