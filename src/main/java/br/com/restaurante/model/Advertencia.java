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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Advertencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_advertencia")
	private Long codigo;

	@ManyToOne()
	@JoinColumn(name = "cd_matricula_aluno")
	@JsonIgnore
	private Aluno aluno;

	@Column(name = "dt_advertencia")
	private LocalDate dataDescricao;

	@Column(name = "ds_advertencia")
	private String descricao;

	@Column(name = "dt_criado_em")
	private LocalDate criadoEm = LocalDate.now();

	@Column(name = "dt_atualizado_em")
	private LocalDate atualizadoEm = LocalDate.now();

	//NÃO PODE EXCLUIR O CONSTRUTOR VAZIO
	public Advertencia() {}

	public Advertencia(Aluno aluno, String descricao, LocalDate dataDescricao) {
		this.aluno = aluno;
		this.descricao = descricao;
		this.dataDescricao = dataDescricao;
	}

	public Advertencia(Long codigo, Aluno aluno, String descricao, LocalDate dataDescricao) {
		this.codigo = codigo;
		this.aluno = aluno;
		this.descricao = descricao;
		this.dataDescricao = dataDescricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public String getDescricao() {
		return descricao;
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

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}

	public LocalDate getDataDescricao() {
		return dataDescricao;
	}

	public void setDataDescricao(LocalDate dataDescricao) {
		this.dataDescricao = dataDescricao;
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
		Advertencia other = (Advertencia) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
