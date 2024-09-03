package br.com.gregoriohd.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlunoDTOResponse {
	
	private Long id;
	private String nome;
	private String sobrenome;
	private LocalDate data_nascimento;
	private String endereco;
	private String telefone;
	private String email;
	private LocalDate data_matricula;

}
