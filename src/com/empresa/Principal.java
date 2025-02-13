package com.empresa;

import com.empresa.model.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        // Criando a lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", "18/10/2000", new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", "12/05/1990", new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", "14/10/1988", new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", "19/11/1999", new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", "08/07/1994", new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", "02/09/1996", new BigDecimal("2799.93"), "Gerente"));

        // Removendo o funcionário chamado "João"
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        // Exibindo funcionários antes do aumento salarial
        System.out.println("\nLista de Funcionários:");
        exibirTabelaFuncionarios(funcionarios);

        // Aplicando um aumento de 10% no salário de todos os funcionários
        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.10"));
            funcionario.setSalario(novoSalario);
        });

        // Exibindo funcionários após aumento salarial
        System.out.println("\nFuncionários após aumento salarial:");
        exibirTabelaFuncionarios(funcionarios);

        // Agrupando os funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // Exibindo os funcionários agrupados por função
        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            exibirTabelaFuncionarios(lista);
        });

        // Exibindo funcionários que fazem aniversário nos meses 10 (Outubro) e 12
        // (Dezembro)
        System.out.println("\nFuncionários que fazem aniversário em outubro e dezembro:");
        List<Funcionario> aniversariantes = funcionarios.stream()
                .filter(funcionario -> {
                    int mes = funcionario.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .collect(Collectors.toList());
        exibirTabelaFuncionarios(aniversariantes);

        // Determinando o funcionário mais velho
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("\nFuncionário mais velho:");
        System.out.printf("%-15s %-6s\n", "Nome", "Idade");
        System.out.println("-------------------");
        System.out.printf("%-15s %-6d\n", maisVelho.getNome(), idade);
        System.out.println("-------------------");

        // Ordenando a lista de funcionários em ordem alfabética
        System.out.println("\nFuncionários ordenados alfabeticamente:");
        List<Funcionario> funcionariosOrdenados = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
        exibirTabelaFuncionarios(funcionariosOrdenados);

        // Calculando e exibindo o total dos salários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários:");
        System.out.printf("R$ %,.2f\n", totalSalarios);

        // Calculando quantos salários mínimos cada funcionário recebe
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalários mínimos recebidos por cada funcionário:");
        System.out.printf("%-15s %-10s\n", "Nome", "Salários Mínimos");
        System.out.println("-----------------------------");
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.printf("%-15s %-10.2f\n", funcionario.getNome(), salariosMinimos);
        });
        System.out.println("-----------------------------");
    }

    // Método auxiliar para exibir funcionários como uma tabela formatada
    public static void exibirTabelaFuncionarios(List<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado.");
            return;
        }

        // Cabeçalho da tabela
        System.out.printf("%-15s %-12s %-12s %-15s%n", "Nome", "Nascimento", "Salário", "Função");
        System.out.println("-------------------------------------------------------------");

        // Impressão de cada funcionário
        for (Funcionario funcionario : funcionarios) {
            System.out.printf("%-15s %-12s %,-12.2f %-15s%n",
                    funcionario.getNome(),
                    funcionario.getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    funcionario.getSalario(),
                    funcionario.getFuncao());
        }
        System.out.println("-------------------------------------------------------------");
    }
}
