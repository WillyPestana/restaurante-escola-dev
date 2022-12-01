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

@Entity
public class AlunoTurma implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_aluno_turma")
	private Long codigo;

	@ManyToOne()
	@JoinColumn(name = "cd_matricula_aluno")
	private Aluno aluno;
	
	@ManyToOne()
	@JoinColumn(name = "cd_turma")
	private Turma turma;
	
	@Column(name = "dt_criado_em")
	private LocalDate criadoEm = LocalDate.now();
	
	@Column(name = "dt_atualizado_em")
	private LocalDate atualizadoEm = LocalDate.now();
	
	//NÃO PODE EXCLUIR O CONSTRUTOR VAZIO
	public AlunoTurma() {}

	public AlunoTurma(Aluno aluno, Turma turma) {
		this.aluno = aluno;
		this.turma = turma;
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
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
		AlunoTurma other = (AlunoTurma) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
