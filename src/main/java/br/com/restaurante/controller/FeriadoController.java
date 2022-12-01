package br.com.restaurante.controller;

import java.net.URI;
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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.restaurante.controller.dto.FeriadoDto;
import br.com.restaurante.controller.form.FeriadoForm;
import br.com.restaurante.model.Feriado;
import br.com.restaurante.service.implementation.FeriadoService;

@RestController
@RequestMapping("/feriado")
public class FeriadoController {
	
	@Autowired
	private FeriadoService service;
	
	@GetMapping
	public ResponseEntity<List<FeriadoDto>> lista() { 
		List<Feriado> feriados = service.findAll();
		return ResponseEntity.ok(FeriadoDto.converter(feriados));
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<FeriadoDto> lista(@PathVariable Long codigo) { 
		Feriado feriado = service.findById(codigo);
		if (feriado != null) {
			return ResponseEntity.ok(FeriadoDto.converter(feriado));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional 
	public ResponseEntity<?> cadastrar(@RequestBody @Valid FeriadoForm form, UriComponentsBuilder uriBuilder) { //o @RequestBody indica ao Spring que os parâmetros enviados no corpo da requisição devem ser atribuídos ao parâmetro do método
		Feriado feriado = form.converter();
		service.create(feriado);
		//jeito mais moderno, o proprio spring instancia o UriComponentsBuilder
		URI uri = uriBuilder.path("/{codigo}").buildAndExpand(feriado.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new FeriadoDto(feriado)); //devolve 201
	}
	
	//Quando configurado o spring security, o spring verifica se a role do usuario é MODERADOR, se nao for, ele nem entra no remover
	@DeleteMapping("/{codigo}")
	@Transactional 
	public ResponseEntity<?> remover(@PathVariable Long codigo) {
		if (service.findById(codigo) != null) {
			service.delete(codigo);
			return ResponseEntity.ok().build(); //vai retornar 200 sem nada no body
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{codigo}")
	@Transactional //avisa pro spring que é pra commitar a transacao, Métodos anotados com @Transactional serão executados dentro de um contexto transacional, Ao finalizar o método, o Spring efetuará o commit automático da transação, caso nenhuma exception tenha sido lançada.
	public ResponseEntity<?> atualizar(@PathVariable Long codigo, @RequestBody @Valid FeriadoForm form) { //preciso colocar no pom a dependencia de validacao
		Feriado feriado = service.findById(codigo);
		if (feriado != null) {
			Feriado feriadoAtualizado = form.converter();
			service.update(feriadoAtualizado);
			FeriadoDto feriadoDto = FeriadoDto.converter(feriadoAtualizado);
			return ResponseEntity.ok(feriadoDto);
		}
		return ResponseEntity.notFound().build();
	}
	
}
