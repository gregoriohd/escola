package br.com.gregoriohd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gregoriohd.core.Aluno;

@Repository
public interface AlunoRespository extends JpaRepository<Aluno, Integer> {
	
	Optional<Aluno> findByEmail(String email);
}
