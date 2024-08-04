package br.com.gregoriohd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gregoriohd.core.Aluno;
import br.com.gregoriohd.repository.AlunoRespository;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {

	@Autowired
	private AlunoRespository alunoRespository;

	public List<Aluno> todosAlunos() {
		return alunoRespository.findAll();
	}

	@Transactional
	public Aluno salvar(Aluno aluno) throws Exception {
		boolean emailEmUso = alunoRespository.findByEmail(aluno.getEmail())
				.stream().anyMatch(alunoExiste -> alunoExiste.equals(aluno));
		if(emailEmUso) {
			throw new Exception("Email ja em uso");
		}
		
		return alunoRespository.save(aluno);
	}

}
