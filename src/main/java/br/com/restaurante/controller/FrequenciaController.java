package br.com.restaurante.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import br.com.restaurante.controller.dto.FaltasDto;
import br.com.restaurante.controller.dto.FrequenciaDto;
import br.com.restaurante.controller.form.FrequenciaForm;
import br.com.restaurante.model.Aluno;
import br.com.restaurante.model.Frequencia;
import br.com.restaurante.model.StatusPresenca;
import br.com.restaurante.model.Turma;
import br.com.restaurante.service.implementation.AlunoService;
import br.com.restaurante.service.implementation.FrequenciaService;
import br.com.restaurante.service.implementation.TurmaService;

@RestController
@RequestMapping("/frequencias")
public class FrequenciaController {

	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private FrequenciaService frequenciaService;

	@GetMapping
	public ResponseEntity<List<FrequenciaDto>> lista() {
		List<Frequencia> frequencias = frequenciaService.findAll();
		return ResponseEntity.ok(FrequenciaDto.converter(frequencias));
	}
	
	@GetMapping("/data")
	public ResponseEntity<List<FrequenciaDto>> listarPorData(@RequestParam(required = true, defaultValue = "1") Integer numeroTurma, @RequestParam(required = true) String data) {
		List<Frequencia> frequencias = frequenciaService.findByData(data, numeroTurma);
		if (frequencias != null) {
			return ResponseEntity.ok(FrequenciaDto.converter(frequencias));
		}
		return ResponseEntity.notFound().build();
	}


	@GetMapping("/{codigo}")
	public ResponseEntity<FrequenciaDto> listarFrequencias(@PathVariable Long codigo) {
		Frequencia frequencia = frequenciaService.findById(codigo);
		if (frequencia != null) {
			return ResponseEntity.ok(FrequenciaDto.converter(frequencia));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/alunos/{matricula}") //metodo que pega as frequencias de um aluno
	public ResponseEntity<List<FrequenciaDto>> listarAlunos(@PathVariable Long matricula) {
		Aluno aluno = alunoService.findById(matricula);
		if(aluno != null) {
			List<Frequencia> frequencias = aluno.getFrequencias();
			if (frequenciaService.findById(frequencias.get(0).getCodigo()) != null) {
				return ResponseEntity.ok(FrequenciaDto.converter(frequencias));
			}
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/alunos/faltas/{matricula}") //metodo que pega as faltas de um aluno
	public ResponseEntity<FaltasDto> listarFaltaAlunos(@PathVariable Long matricula) {
		Aluno aluno = alunoService.findById(matricula);
		if(aluno != null) {
			List<Frequencia> frequencias = aluno.getFrequencias();
			if (frequenciaService.findById(frequencias.get(0).getCodigo()) != null) {
				List<Frequencia> faltas = frequencias.stream().filter(f -> f.getStatus().equals(StatusPresenca.FALTA) || f.getStatus().equals(StatusPresenca.MEIA)).collect(Collectors.toList());
				return ResponseEntity.ok(FaltasDto.converter(faltas.size(), FrequenciaDto.converter(faltas)));
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarFrequencia(@RequestBody @Valid FrequenciaForm form) {
		Aluno aluno = alunoService.findById(form.getMatricula());
		Turma turma = turmaService.findByCodigoTurma(form.getNumeroTurma());
		Frequencia frequencia = form.converterParaCriar(aluno, turma);
		frequenciaService.create(frequencia);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> removerFrequencia(@PathVariable Long codigo) {
		if (frequenciaService.findById(codigo) != null) {
			frequenciaService.delete(codigo);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> atualizarFrequencia(@PathVariable Long codigo, @RequestBody @Valid FrequenciaForm form) {
		Aluno aluno = alunoService.findById(form.getMatricula());
		Turma turma = turmaService.findByCodigoTurma(form.getNumeroTurma());
		Frequencia frequencia = frequenciaService.findById(codigo);
		if (aluno != null  && turma != null && frequencia != null ) {
			Frequencia frequenciaAtualizada = form.converterAtualizar(aluno, turma, codigo);
			frequenciaService.update(frequenciaAtualizada); 
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
