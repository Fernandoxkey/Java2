package telas;

import empresa.Servicos;
import servico.ServicosServico;

import java.util.Scanner;

public class TelaServicos {
    public static void executar(Scanner scanner) {
        ServicosServico servico = new ServicosServico();
        System.out.println("Servicos Cadastrados:");
        var serv = servico.listarTodos();
        for (var servicos : serv) {
            System.out.println(servicos.getId() + " - " + servicos.getDescricao());
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

    private static void inserir(Scanner scanner, ServicosServico servico) {
        System.out.println("Descricao:");
        var descricao = scanner.nextLine();
        System.out.println("Preco:");
        var preco = Float.parseFloat(scanner.nextLine());
        System.out.println("SLA:");
        var sla = Integer.parseInt(scanner.nextLine());
        var servicos = new Servicos();
        servicos.setDescricao(descricao);
        servicos.setPreco(preco);
        servicos.setSla(sla);
        servico.inserir(servicos);
    }
    private static void alterar(Scanner scanner, ServicosServico servico) {
        System.out.println("Digite o ID do Aluno que deseja alterar:");
        var id = Long.parseLong(scanner.nextLine());
        var servicos = servico.encontrarServicos(id);
        if (servicos != null) {
            System.out.println("Descricao:[" + servicos.getDescricao() + "]");
            var descricao = scanner.nextLine();
            System.out.println("Preco:[" + servicos.getPreco() + "]");
            var preco = Float.parseFloat(scanner.nextLine());
            System.out.println("SLA:[" + servicos.getSla() + "]");
            var sla = Integer.parseInt(scanner.nextLine());
            servicos.setDescricao(descricao);
            servicos.setPreco(preco);
            servicos.setSla(sla);
            servico.alterar(servicos);
        }
    }
    private static void excluir(Scanner scanner, ServicosServico servico) {
        System.out.println("Digite o ID da Servicos que deseja Excluir:");
        var id = Long.parseLong(scanner.nextLine());
        servico.excluir(id);
    }
}
