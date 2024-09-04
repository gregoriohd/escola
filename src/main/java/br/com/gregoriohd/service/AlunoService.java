package br.com.gregoriohd.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.gregoriohd.dto.AlunoDTORequest;
import br.com.gregoriohd.dto.AlunoDTOResponse;
import br.com.gregoriohd.entity.Aluno;
import br.com.gregoriohd.repository.AlunoRespository;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {

	@Autowired
	private AlunoRespository alunoRepository;

	@Autowired
	private ModelMapper mapper;

	public List<AlunoDTOResponse> todosAlunos() {

		@SuppressWarnings("unchecked")
		List<AlunoDTOResponse> listDTO = mapper.map(alunoRepository.findAll(), List.class);
		return listDTO;
	}

	@Transactional
	public AlunoDTOResponse salvar(AlunoDTORequest alunoDTORequest) {
		AlunoDTOResponse alunoDTOResponse;
		try {

			Aluno aluno = mapper.map(alunoDTORequest, Aluno.class);

			aluno = alunoRepository.save(aluno);

			alunoDTOResponse = mapper.map(aluno, AlunoDTOResponse.class);

		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException(" Email em uso ");
		}

		return alunoDTOResponse;
	}

	public String atualizar(String email, AlunoDTORequest alunoDTORequest) {
		
		Optional<Aluno> op = alunoRepository.findByEmail(email);
		
		if(op.isPresent()) {
			
			Aluno aluno = op.orElse(new Aluno());
			Integer id = aluno.getId();
			aluno = mapper.map(alunoDTORequest, Aluno.class);
			aluno.setId(id);
			alunoRepository.save(aluno);
			
			return "sucesso";
			
		}else {
			return "insucesso";
		}
		
		
		
	}

}
