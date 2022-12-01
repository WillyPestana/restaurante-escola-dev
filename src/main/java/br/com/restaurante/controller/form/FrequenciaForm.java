package br.com.restaurante.controller.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;

import br.com.restaurante.model.Aluno;
import br.com.restaurante.model.Frequencia;
import br.com.restaurante.model.StatusPresenca;
import br.com.restaurante.model.Turma;

public class FrequenciaForm {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@NotNull(message = "O campo status é obrigatório")
	private String status;

	@NotNull(message = "O campo numeroTurma é obrigatório")
	private Integer numeroTurma;

	@NotNull(message = "O campo matricula é obrigatório")
	private Long matricula;
	
	@NotNull(message = "O campo dataAula é obrigatório")
	private String dataAula;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNumeroTurma() {
		return numeroTurma;
	}

	public void setNumeroTurma(Integer numeroTurma) {
		this.numeroTurma = numeroTurma;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getDataAula() {
		return dataAula;
	}

	public void setDataAula(String dataAula) {
		this.dataAula = dataAula;
	}
	
	public Frequencia converterAtualizar(Aluno aluno, Turma turma, Long codigoFrequencia) {
		return new Frequencia(codigoFrequencia, aluno, turma, StatusPresenca.valueOf(status.toUpperCase()) , LocalDate.parse(dataAula, formatter));
	}
	
	public Frequencia converterParaCriar(Aluno aluno, Turma turma) {
		return new Frequencia(aluno, turma, StatusPresenca.valueOf(status.toUpperCase()) , LocalDate.parse(dataAula, formatter));
	}
}
