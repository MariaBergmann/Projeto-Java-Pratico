// Define o pacote onde a classe Funcionario está contida.
package com.empresa.model;

// Importa a classe BigDecimal para trabalhar com números de alta precisão, útil para representar valores monetários.
import java.math.BigDecimal;

// A classe Funcionario estende a classe Pessoa, herdando seus atributos e métodos.
public class Funcionario extends Pessoa {

    // Atributo privado para armazenar o salário do funcionário com alta precisão.
    private BigDecimal salario;

    // Atributo privado para armazenar a função ou cargo do funcionário.
    private String funcao;

    /**
     * Construtor da classe Funcionario.
     *
     * @param nome           Nome do funcionário (passado para a classe Pessoa).
     * @param dataNascimento Data de nascimento do funcionário (passado para a
     *                       classe Pessoa).
     * @param salario        Salário do funcionário, representado por BigDecimal.
     * @param funcao         Função ou cargo do funcionário.
     */
    public Funcionario(String nome, String dataNascimento, BigDecimal salario, String funcao) {
        // Chama o construtor da superclasse Pessoa para inicializar os atributos nome e
        // dataNascimento.
        super(nome, dataNascimento);
        // Inicializa o atributo salario com o valor passado como parâmetro.
        this.salario = salario;
        // Inicializa o atributo funcao com o valor passado como parâmetro.
        this.funcao = funcao;
    }

    /**
     * Método getter para o atributo salario.
     *
     * @return O salário do funcionário.
     */
    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * Método setter para o atributo salario.
     *
     * @param salario Novo valor para o salário do funcionário.
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    /**
     * Método getter para o atributo funcao.
     *
     * @return A função ou cargo do funcionário.
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * Sobrescrita do método toString() para fornecer uma representação em string
     * do objeto Funcionario, combinando informações herdadas de Pessoa com os
     * atributos específicos.
     *
     * @return Uma String formatada com os dados do funcionário.
     */
    @Override
    public String toString() {
        // Chama o método toString() da classe Pessoa e concatena com os atributos
        // salario e funcao.
        // O salário é formatado para duas casas decimais, com separador de milhar se
        // necessário.
        return super.toString() + ", Salário: " + String.format("%,.2f", salario) + ", Função: " + funcao;
    }
}
