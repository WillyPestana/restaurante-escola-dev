package br.com.restaurante.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "FREQUENCIA_ALUNO")
public class Frequencia implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_frequencia")
	@NotNull
	private Long codigo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "cd_status_presenca")
	private StatusPresenca status;
	
	@ManyToOne()
	@JoinColumn(name = "cd_turma")
	@JsonIgnore
	private Turma turma;

	@ManyToOne()
	@JoinColumn(name = "cd_matricula_aluno")
	@JsonIgnore
	private Aluno aluno;
	
	@Column(name = "dt_aula")
	private LocalDate dataAula;

	@Column(name = "dt_criado_em")
	private LocalDate criadoEm = LocalDate.now();

	@Column(name = "dt_atualizado_em")
	private LocalDate atualizadoEm = LocalDate.now();
	
	//NÃO PODE EXCLUIR O CONSTRUTOR VAZIO
	public Frequencia() {}

	public Frequencia(Aluno aluno, Turma turma, StatusPresenca status, LocalDate dataAula) {
		this.aluno = aluno;
		this.turma = turma;
		this.status = status;
		this.dataAula = dataAula;
	}

	public Frequencia(Long codigoFrequencia, Aluno aluno, Turma turma, StatusPresenca status, LocalDate dataAula) {
		this.aluno = aluno;
		this.turma = turma;
		this.status = status;
		this.dataAula = dataAula;
		this.codigo = codigoFrequencia;
	}

	public Long getCodigo() {
		return codigo;
	}

	public Turma getTurma() {
		return turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public LocalDate getDataAula() {
		return dataAula;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}

	public LocalDate getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(LocalDate atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}
	
	public StatusPresenca getStatus() {
		return status;
	}

	public void setStatus(StatusPresenca status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frequencia other = (Frequencia) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
