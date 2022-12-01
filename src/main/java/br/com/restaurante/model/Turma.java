package br.com.restaurante.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Turma implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_turma")
	@NotNull
	private Long codigo;
	
	@Column(name = "cd_numero_turma")
	private Integer numero;
	
	@Column(name = "dt_inicio_turma")
	private LocalDate inicioTurma; 
	
	@Column(name = "dt_fim_turma")
	private LocalDate fimTurma;
	
	@Column(name = "dt_criado_em")
	private LocalDate criadoEm = LocalDate.now();
	
	@Column(name = "dt_atualizado_em")
	private LocalDate atualizadoEm = LocalDate.now();
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
	private List<AlunoTurma> turma;
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
	private List<DisciplinaTurma> turmaDisicplina;

	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
	private List<Frequencia> frequencias;

	//NÃO PODE EXCLUIR O CONSTRUTOR VAZIO
	public Turma() {}
	
	public Turma(Long codigo, Integer numero, LocalDate inicioTurma, LocalDate fimTurma) {
		this.codigo = codigo;
		this.numero = numero;
		this.inicioTurma = inicioTurma;
		this.fimTurma = fimTurma;
	}

	public Turma(Integer numero, LocalDate inicioTurma, LocalDate fimTurma) {
		this.numero = numero;
		this.inicioTurma = inicioTurma;
		this.fimTurma = fimTurma;
	}

	public Long getCodigo() {
		return codigo;
	}

	public Integer getNumero() {
		return numero;
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

//	public void setDisciplinas(List<Disciplina> disciplinas) {
//		this.disciplinas = disciplinas;
//	}
//
//	public List<Disciplina> getDisciplinas() {
//		return disciplinas;
//	}

	public List<AlunoTurma> getTurma() {
		return turma;
	}

	public void setTurma(List<AlunoTurma> turma) {
		this.turma = turma;
	}

	public List<Frequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}

	public List<DisciplinaTurma> getTurmaDisicplina() {
		return turmaDisicplina;
	}

	public void setTurmaDisicplina(List<DisciplinaTurma> turmaDisicplina) {
		this.turmaDisicplina = turmaDisicplina;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}

	public LocalDate getInicioTurma() {
		return inicioTurma;
	}

	public void setInicioTurma(LocalDate inicioTurma) {
		this.inicioTurma = inicioTurma;
	}

	public LocalDate getFimTurma() {
		return fimTurma;
	}

	public void setFimTurma(LocalDate fimTurma) {
		this.fimTurma = fimTurma;
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
		Turma other = (Turma) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
