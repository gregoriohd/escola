package br.com.gregoriohd.dto;

import java.time.LocalDate;

public record AlunoRequestDTO(String nome, String sobrenome, LocalDate data_nascimento, String endereco,
		String telefone, String email, LocalDate data_matricula) {
}
