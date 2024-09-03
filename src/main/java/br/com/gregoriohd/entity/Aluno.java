package br.com.gregoriohd.entity;

import java.time.LocalDate;

import br.com.gregoriohd.mapped.Pessoa;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "alunos", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"email"})
	})
public class Aluno extends Pessoa {
	
	private String endereco;

	private String telefone;
	
	@Nonnull
	@Email
	@NotBlank
	private String email;

	private final LocalDate data_matricula = LocalDate.now();

}
