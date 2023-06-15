package telas;

import empresa.Profissional;
import servico.ProfissionalServico;

import java.util.Scanner;

public class TelaProfissional {
    public static void executar(Scanner scanner) {
        ProfissionalServico servico = new ProfissionalServico();
        System.out.println("Profissional Cadastrados:");
        var profissionais = servico.listarTodos();
        for (var profissional : profissionais) {
            System.out.println(profissional.getId() + " - " + profissional.getNome());
        }

        System.out.println("-----------------------------------");
        System.out.println("Selecione uma Opção:");
        System.out.println("-----------------------------------");
        System.out.println("1 - Inserir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("0 - Voltar ao Menu Inicial");
        System.out.println("-----------------------------------");
        var opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                inserir(scanner, servico);
                break;
            case "2":
                alterar(scanner, servico);
                break;
            case "3":
                excluir(scanner, servico);
                break;
            case "0":
                break;
            default:
                System.out.println("Opcao Invalida!");
        }

    }

    private static void inserir(Scanner scanner, ProfissionalServico servico) {
        System.out.println("Nome:");
        var nome = scanner.nextLine();
        var profissional = new Profissional();
        profissional.setNome(nome);
        servico.inserir(profissional);
    }
    private static void alterar(Scanner scanner, ProfissionalServico servico) {
        System.out.println("Digite o ID do Profissional que deseja alterar:");
        var id = Long.parseLong(scanner.nextLine());
        var profissional = servico.encontrarProfissional(id);
        if (profissional != null) {
            System.out.println("Nome:[" + profissional.getNome() + "]");
            var nome = scanner.nextLine();
            profissional.setNome(nome);
            servico.alterar(profissional);
        }
    }
    private static void excluir(Scanner scanner, ProfissionalServico servico) {
        System.out.println("Digite o ID da Profissional que deseja Excluir:");
        var id = Long.parseLong(scanner.nextLine());
        servico.excluir(id);
    }
}
