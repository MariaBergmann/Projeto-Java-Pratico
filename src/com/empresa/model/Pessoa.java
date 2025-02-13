// Define o pacote onde a classe Pessoa está contida. Isso ajuda na organização das classes.
package com.empresa.model;

// Importa a classe LocalDate para trabalhar com datas (sem horário).
import java.time.LocalDate;

// Declaração da classe Pessoa, que é pública e pode ser utilizada em outros pacotes.
public class Pessoa {

    // Atributo privado para armazenar o nome da pessoa.
    private String nome;

    // Atributo privado para armazenar a data de nascimento da pessoa.
    // Utiliza a classe LocalDate, que representa uma data sem o componente de
    // tempo.
    private LocalDate dataNascimento;

    /**
     * Construtor da classe Pessoa.
     *
     * @param nome           - Recebe uma String representando o nome da pessoa.
     * @param dataNascimento - Recebe uma String representando a data de nascimento
     *                       no formato "dd/MM/yyyy".
     */
    public Pessoa(String nome, String dataNascimento) {
        // Atribui o valor do parâmetro 'nome' ao atributo da instância.
        this.nome = nome;

        // Converte a string 'dataNascimento' para um objeto LocalDate utilizando o
        // formato "dd/MM/yyyy".
        // O método LocalDate.parse() analisa a string conforme o padrão especificado
        // pelo DateTimeFormatter.
        this.dataNascimento = LocalDate.parse(dataNascimento,
                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /**
     * Método getter para o atributo nome.
     *
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método getter para o atributo dataNascimento.
     *
     * @return A data de nascimento da pessoa.
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sobrescrita do método toString() para fornecer uma representação em string
     * da instância da classe Pessoa.
     *
     * @return Uma String formatada com o nome e a data de nascimento.
     */
    @Override
    public String toString() {
        // Formata a data de nascimento para o padrão "dd/MM/yyyy" e retorna a string
        // concatenada.
        return "Nome: " + nome + ", Data Nascimento: "
                + dataNascimento.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

/*
 * Esta classe contém os atributos 'nome' e 'dataNascimento',
 * permitindo a criação de objetos que representam pessoas com seu nome e data
 * de nascimento.
 * Inclui um construtor para inicializar esses atributos, métodos getters para
 * acesso,
 * e uma sobrescrita do método toString() para uma exibição formatada dos dados
 * da pessoa.
 */
