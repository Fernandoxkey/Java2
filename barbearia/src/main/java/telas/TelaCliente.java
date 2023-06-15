package telas;

import empresa.Cliente;
import servico.ClienteServico;

import java.time.LocalDate;
import java.util.Scanner;

public class TelaCliente {
    public static void executar(Scanner scanner) {
        ClienteServico servico = new ClienteServico();
        System.out.println("Clientes Cadastrados:");
        var clientes = servico.listarTodos();
        for (var cliente : clientes) {
            System.out.println(cliente.getId() + " - " + cliente.getNome());
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

    private static void inserir(Scanner scanner, ClienteServico servico) {
        System.out.println("Nome:");
        var nome = scanner.nextLine();
        System.out.println("Endereco:");
        var endereco = scanner.nextLine();
        System.out.println("Numero:");
        var numero = Integer.parseInt(scanner.nextLine());
        System.out.println("Complemento:");
        var complemento = scanner.nextLine();
        System.out.println("CPF:");
        var cpf = scanner.nextLine();
        System.out.println("Cidade:");
        var cidade = scanner.nextLine();
        System.out.println("Estado:");
        var uf = scanner.nextLine();
        System.out.println("Data Cadastro:");
        var dataCadastro = LocalDate.parse(scanner.nextLine());
        System.out.println("Telefone:");
        var telefone = scanner.nextLine();
        var cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEndereco(endereco);
        cliente.setNumero(numero);
        cliente.setComplemento(complemento);
        cliente.setCpf(cpf);
        cliente.setCidade(cidade);
        cliente.setUf(uf);
        cliente.setDataCadastro(dataCadastro);
        cliente.setTelefone(telefone);
        servico.inserir(cliente);
    }
    private static void alterar(Scanner scanner, ClienteServico servico) {
        System.out.println("Digite o ID do Aluno que deseja alterar:");
        var id = Long.parseLong(scanner.nextLine());
        var cliente = servico.encontrarCliente(id);
        if (cliente != null) {
            System.out.println("Nome:[" + cliente.getNome() + "]");
            var nome = scanner.nextLine();
            System.out.println("Endereco:[" + cliente.getEndereco() + "]");
            var endereco = scanner.nextLine();
            System.out.println("Numero:[" + cliente.getNumero() + "]");
            var numero = Integer.parseInt(scanner.nextLine());
            System.out.println("Complemento:[" + cliente.getComplemento() + "]");
            var complemento = scanner.nextLine();
            System.out.println("CPF:[" + cliente.getCpf() + "]");
            var cpf = scanner.nextLine();
            System.out.println("Cidade:[" + cliente.getCidade() + "]");
            var cidade = scanner.nextLine();
            System.out.println("Estado:[" + cliente.getUf() + "]");
            var uf = scanner.nextLine();
            System.out.println("Data Cadastro:[" + cliente.getDataCadastro() + "]");
            var dataCadastro = LocalDate.parse(scanner.nextLine());
            System.out.println("Telefone:[" + cliente.getTelefone() + "]");
            var telefone = scanner.nextLine();
            cliente.setNome(nome);
            cliente.setEndereco(endereco);
            cliente.setNumero(numero);
            cliente.setComplemento(complemento);
            cliente.setCpf(cpf);
            cliente.setCidade(cidade);
            cliente.setUf(uf);
            cliente.setDataCadastro(dataCadastro);
            cliente.setTelefone(telefone);
            servico.alterar(cliente);
        }
    }
    private static void excluir(Scanner scanner, ClienteServico servico) {
        System.out.println("Digite o ID da Cliente que deseja Excluir:");
        var id = Long.parseLong(scanner.nextLine());
        servico.excluir(id);
    }
}
