package br.com.restaurante.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.restaurante.model.Turma;

public class TurmaDto {
	
	private Long codigo;

	private Integer numero;
	
	private String inicioTurma = "indefinido";
	
	private String fimTurma = "indefinido";

	private LocalDate criadoEm;

	private LocalDate atualizadoEm;
	
	//no futuro colocar os atributos alunos, bla bla bla

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getInicioTurma() {
		return inicioTurma;
	}

	public void setInicioTurma(String inicioTurma) {
		this.inicioTurma = inicioTurma;
	}

	public String getFimTurma() {
		return fimTurma;
	}

	public void setFimTurma(String fimTurma) {
		this.fimTurma = fimTurma;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}

	public LocalDate getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(LocalDate atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public TurmaDto(Turma turma) {
		this.codigo = turma.getCodigo();
		this.numero = turma.getNumero();
		this.inicioTurma = turma.getInicioTurma().toString();
		if (turma.getFimTurma() != null) {
			this.fimTurma = turma.getFimTurma().toString();
		}
		this.criadoEm = turma.getCriadoEm();
		this.atualizadoEm = turma.getAtualizadoEm();
	}
	
	public static List<TurmaDto> converter(List<Turma> listaTurma) {
		return listaTurma.stream().map(turma -> new TurmaDto(turma)).collect(Collectors.toList());
	}

	public static TurmaDto converter(Turma turma) {
		return new TurmaDto(turma);
	}

}
