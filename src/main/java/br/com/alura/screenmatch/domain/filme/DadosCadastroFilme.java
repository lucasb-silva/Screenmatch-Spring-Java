package br.com.alura.screenmatch.domain.filme;

// Record para representar os dados do cadastro, utilizados no construtor da classe
public record DadosCadastroFilme(String nome, Integer duracao, Integer ano, String genero) {
}
