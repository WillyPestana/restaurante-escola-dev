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

import br.com.restaurante.controller.dto.AdvertenciaDto;
import br.com.restaurante.controller.form.AdvertenciaForm;
import br.com.restaurante.model.Advertencia;
import br.com.restaurante.model.Aluno;
import br.com.restaurante.service.implementation.AdvertenciaService;
import br.com.restaurante.service.implementation.AlunoService;

@RestController
@RequestMapping("/advertencias")
public class AdvertenciaController {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AdvertenciaService advertenciaService;

	@GetMapping
	public ResponseEntity<List<AdvertenciaDto>> lista() {
		List<Advertencia> advertencias = advertenciaService.findAll();
		return ResponseEntity.ok(AdvertenciaDto.converter(advertencias));
	}

	@GetMapping("/aluno/{matricula}")
	public ResponseEntity<List<AdvertenciaDto>> listaPorMatricula(@PathVariable Long matricula) {
		Aluno aluno = alunoService.findById(matricula);
		if (aluno != null) { //NAO TA ACHANDO O ALUNO POR ID	
			List<Advertencia> listaAdvertencias = advertenciaService.findListByAluno(aluno);
			return ResponseEntity.ok(AdvertenciaDto.converter(listaAdvertencias));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<AdvertenciaDto> lista(@PathVariable Long codigo) {
		Advertencia advertencia = advertenciaService.findById(codigo);
		if (advertencia != null) {
			return ResponseEntity.ok(AdvertenciaDto.converter(advertencia));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AdvertenciaForm form) {
		Aluno aluno = alunoService.findById(form.getMatricula());
		if (aluno != null) {
			Advertencia advertencia = form.converterParaCriar(aluno);
			advertenciaService.create(advertencia);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long codigo) {
		if (advertenciaService.findById(codigo) != null) {
			advertenciaService.delete(codigo);
			return ResponseEntity.ok().build(); // vai retornar 200 sem nada no body
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable Long codigo, @RequestBody @Valid AdvertenciaForm form) {
		Advertencia advertencia = advertenciaService.findById(codigo);
		if (advertencia != null) {
			Advertencia advertenciaAtualizado = form.converterParaAtualizar(codigo, advertencia.getAluno());
			advertenciaService.update(advertenciaAtualizado); 
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
