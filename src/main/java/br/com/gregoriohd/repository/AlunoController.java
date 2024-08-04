package br.com.gregoriohd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gregoriohd.core.Aluno;
import br.com.gregoriohd.service.AlunoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> todosAlunos() {
		return ResponseEntity.ok(alunoService.todosAlunos());
	}
	
	@PostMapping
	public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno) throws Exception{
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(aluno));
	}

}
