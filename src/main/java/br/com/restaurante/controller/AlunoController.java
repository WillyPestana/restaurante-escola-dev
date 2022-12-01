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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurante.controller.dto.AlunoDto;
import br.com.restaurante.controller.form.AlunoForm;
import br.com.restaurante.model.Aluno;
import br.com.restaurante.service.implementation.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping //traz uma lista de alunos, se tiver o codigo da turma, traz apenas os alunos daquela turma
	public ResponseEntity<List<AlunoDto>> lista(@RequestParam(required = false) String codigoTurma) { 
		if (codigoTurma != null) {
			List<Aluno> alunos = service.findByTurma(codigoTurma);
			return ResponseEntity.ok(AlunoDto.converter(alunos));
		}
		List<Aluno> alunos = service.findAll();
		return ResponseEntity.ok(AlunoDto.converter(alunos)); // O Spring faz a conversão do objeto para JSON automaticamente, com o uso da biblioteca Jackson.
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity<AlunoDto> lista(@PathVariable Long matricula) { 
		if (service.findById(matricula) != null) {
			Aluno aluno = service.findById(matricula);
			return ResponseEntity.ok(AlunoDto.converter(aluno));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/nome")
	public ResponseEntity<List<AlunoDto>> listaPorNome(@RequestParam(required = true) String nome) { 
		List<Aluno> alunos = service.findByNome(nome);
		if (alunos != null) {
			return ResponseEntity.ok(AlunoDto.converter(alunos));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional 
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AlunoForm form) { //o @RequestBody indica ao Spring que os parâmetros enviados no corpo da requisição devem ser atribuídos ao parâmetro do método
		Aluno aluno = form.converter();
		service.create(aluno);
		return ResponseEntity.ok().build();
	}
	
	//Quando configurado o spring security, o spring verifica se a role do usuario é MODERADOR, se nao for, ele nem entra no remover
	@DeleteMapping("/{matricula}")
	@Transactional 
	public ResponseEntity<?> remover(@PathVariable Long matricula) {
		if (service.findById(matricula) != null) {
			service.delete(matricula);
			return ResponseEntity.ok().build(); //vai retornar 200 sem nada no body
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{matricula}")
	@Transactional //avisa pro spring que é pra commitar a transacao, Métodos anotados com @Transactional serão executados dentro de um contexto transacional, Ao finalizar o método, o Spring efetuará o commit automático da transação, caso nenhuma exception tenha sido lançada.
	public ResponseEntity<?> atualizar(@PathVariable Long matricula, @RequestBody @Valid AlunoForm form) { //preciso colocar no pom a dependencia de validacao
		Aluno aluno = service.findById(matricula);
		if (aluno != null) {
			Aluno alunoAtualizado = form.converter();
			service.update(alunoAtualizado);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
