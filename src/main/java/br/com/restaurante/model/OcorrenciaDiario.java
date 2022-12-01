package br.com.restaurante.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "OCORRENCIA_DIARIO")
public class OcorrenciaDiario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_ocorrencia")
	@NotNull
	private Long codigo;

	@ManyToOne()
	@JoinColumn(name = "cd_matricula_aluno")
	@JsonIgnore
	private Aluno aluno;

	@Column(name = "ds_ocorrencia")
	private String ocorrencia;

	@Column(name = "dt_ocorrencia")
	private LocalDate dataOcorrencia;

	@Column(name = "dt_criado_em")
	private LocalDate criadoEm = LocalDate.now();

	@Column(name = "dt_atualizado_em")
	private LocalDate atualizadoEm = LocalDate.now();

	//NÃO PODE EXCLUIR O CONSTRUTOR VAZIO
	public OcorrenciaDiario() {}

	public OcorrenciaDiario(Long codigo, Aluno aluno, String ocorrencia,
			LocalDate dataOcorrencia) {
		this.codigo = codigo;
		this.aluno = aluno;
		this.ocorrencia = ocorrencia;
		this.dataOcorrencia = dataOcorrencia;
	}

	public OcorrenciaDiario(Aluno aluno, String ocorrencia, LocalDate dataOcorrencia) {
		this.aluno = aluno;
		this.ocorrencia = ocorrencia;
		this.dataOcorrencia = dataOcorrencia;
	}

	public Long getCodigo() {
		return codigo;
	}

	public Aluno getAluno() {
		return aluno;
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

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}

	public LocalDate getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(LocalDate dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
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
		OcorrenciaDiario other = (OcorrenciaDiario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
