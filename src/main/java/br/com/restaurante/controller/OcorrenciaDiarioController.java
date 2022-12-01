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

import br.com.restaurante.controller.dto.OcorrenciaDiarioDto;
import br.com.restaurante.controller.form.OcorrenciaDiarioForm;
import br.com.restaurante.model.Aluno;
import br.com.restaurante.model.OcorrenciaDiario;
import br.com.restaurante.service.implementation.AlunoService;
import br.com.restaurante.service.implementation.OcorrenciaDiarioService;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaDiarioController {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private OcorrenciaDiarioService ocorrenciaDiarioService;

	@GetMapping
	public ResponseEntity<List<OcorrenciaDiarioDto>> lista() {
		List<OcorrenciaDiario> ocorrencias = ocorrenciaDiarioService.findAll();
		return ResponseEntity.ok(OcorrenciaDiarioDto.converter(ocorrencias));
	}

	@GetMapping("/aluno/{matricula}")
	public ResponseEntity<List<OcorrenciaDiarioDto>> listaPorMatricula(@PathVariable Long matricula) {
		Aluno aluno = alunoService.findById(matricula);
		if (aluno != null) { //NAO TA ACHANDO O ALUNO POR ID	
			List<OcorrenciaDiario> listaOcorrencias = ocorrenciaDiarioService.findListByAluno(aluno);
			return ResponseEntity.ok(OcorrenciaDiarioDto.converter(listaOcorrencias));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OcorrenciaDiarioDto> lista(@PathVariable Long codigo) {
		OcorrenciaDiario ocorrenciaDiario = ocorrenciaDiarioService.findById(codigo);
		if (ocorrenciaDiario != null) {
			return ResponseEntity.ok(OcorrenciaDiarioDto.converter(ocorrenciaDiario));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid OcorrenciaDiarioForm form) {
		Aluno aluno = alunoService.findById(form.getMatricula());
		if (aluno != null) {
			OcorrenciaDiario ocorrenciaDiario = form.converter(aluno);
			ocorrenciaDiarioService.create(ocorrenciaDiario);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long codigo) {
		if (ocorrenciaDiarioService.findById(codigo) != null) {
			ocorrenciaDiarioService.delete(codigo);
			return ResponseEntity.ok().build(); // vai retornar 200 sem nada no body
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable Long codigo, @RequestBody @Valid OcorrenciaDiarioForm form) {
		OcorrenciaDiario ocorrencia = ocorrenciaDiarioService.findById(codigo);
		if (ocorrencia != null) {
			OcorrenciaDiario ocorrenciaDiarioAtualizado = form.converter(codigo, ocorrencia.getAluno());
			ocorrenciaDiarioService.update(ocorrenciaDiarioAtualizado); 
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
