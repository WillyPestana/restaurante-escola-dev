package br.com.restaurante.controller.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;

import br.com.restaurante.model.Advertencia;
import br.com.restaurante.model.Aluno;

public class AdvertenciaForm {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@NotNull
	private Long matricula;

	private String descricao;

	private String data;
	
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Advertencia converterParaAtualizar(Long codigo, Aluno aluno) {
		return new Advertencia(codigo, aluno, descricao, LocalDate.parse(data, formatter));
	}

	public Advertencia converterParaCriar(Aluno aluno) {
		return new Advertencia(aluno, descricao, LocalDate.parse(data, formatter));
	}
}
