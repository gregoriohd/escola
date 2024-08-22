package br.com.gregoriohd.entity;

import java.time.LocalDate;

 
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Alunos")
public class Aluno {

	@Column(name = "aluno_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	@NotBlank
	private String nome;
	
	private LocalDate data_nascimento;

	private String endereco;

	private String telefone;

	@Nonnull
	@Email
	@NotBlank
	private String email;

	private final LocalDate data_matricula = LocalDate.now();

}
