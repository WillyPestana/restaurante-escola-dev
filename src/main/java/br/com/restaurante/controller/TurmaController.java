package br.com.restaurante.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurante.controller.dto.AlunoDto;
import br.com.restaurante.controller.dto.TurmaDto;
import br.com.restaurante.controller.form.AlunoTurmaForm;
import br.com.restaurante.controller.form.TurmaForm;
import br.com.restaurante.model.Aluno;
import br.com.restaurante.model.AlunoTurma;
import br.com.restaurante.model.Turma;
import br.com.restaurante.service.implementation.AlunoService;
import br.com.restaurante.service.implementation.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<TurmaDto>> lista() {
		List<Turma> turmas = turmaService.findAll();
		return ResponseEntity.ok(TurmaDto.converter(turmas));
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<TurmaDto> listarTurmas(@PathVariable Integer codigo) {
		Turma turma = turmaService.findByCodigoTurma(codigo);
		if (turma != null) {
			return ResponseEntity.ok(TurmaDto.converter(turma));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/alunos/{codigo}") //metodo que pega os alunos por turma
	public ResponseEntity<List<AlunoDto>> listarAlunos(@PathVariable Integer codigo) {
		if (turmaService.findByCodigoTurma(codigo) != null) {
			List<Aluno> alunos = turmaService.findAlunos(codigo);
			return ResponseEntity.ok(AlunoDto.converter(alunos));
		}
		return ResponseEntity.notFound().build();
	}
	

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarTurma(@RequestBody @Valid TurmaForm form) {
		if(!existeTurma(form)) {
			Turma turma = form.converterParaCriar();
			turmaService.create(turma);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}

	private boolean existeTurma(TurmaForm form) {
		try {
			return turmaService.findByCodigoTurma(form.getNumero()).getNumero().equals(form.getNumero());
		} catch (Exception e) {
			return false;
		}
	}
	
	@PostMapping("/cadastrar-alunos")
	@Transactional
	public ResponseEntity<?> atualizarTurmas(@RequestBody @Valid AlunoTurmaForm form) {
		Aluno aluno = alunoService.findById(form.getMatricula());
		Turma turma = turmaService.findByCodigoTurma(form.getNumeroTurma());
		if (turma != null && aluno != null) {
			AlunoTurma alunoTurma = form.converterParaCriar(aluno, turma);
			turmaService.cadastrarAlunoTurma(alunoTurma);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> removerTurma(@PathVariable Integer codigo) {
		if (turmaService.findByCodigoTurma(codigo) != null) {
			turmaService.delete(codigo);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> atualizarTurma(@PathVariable Integer codigo, @RequestBody @Valid TurmaForm form) {
		Turma turma = turmaService.findByCodigoTurma(codigo);
		if (turma != null) {
			Turma turmaAtualizada = form.converterAtualizar(turma);
			turmaService.update(turmaAtualizada); 
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
