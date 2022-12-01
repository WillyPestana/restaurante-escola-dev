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
public class Disciplina implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_disciplina")
	@NotNull
	private Long codigo;
	
	@Column(name = "nm_disciplina")
	private String nome;
	
	@Column(name = "dt_criado_em")
	private LocalDate criadoEm = LocalDate.now();
	
	@Column(name = "dt_atualizado_em")
	private LocalDate atualizadoEm = LocalDate.now();

	@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
	private List<DisciplinaTurma> disciplinaTurma;

	@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
	private List<Boletim> boletins;

	//NÃO PODE EXCLUIR O CONSTRUTOR VAZIO
	public Disciplina() {}

	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}

	public LocalDate getAtualizadoEm() {
		return atualizadoEm;
	}

	public List<Boletim> getBoletins() {
		return boletins;
	}

	public void setAtualizadoEm(LocalDate atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public void setBoletins(List<Boletim> boletins) {
		this.boletins = boletins;
	}

	public List<DisciplinaTurma> getDisciplinaTurma() {
		return disciplinaTurma;
	}

	public void setDisciplinaTurma(List<DisciplinaTurma> disciplinaTurma) {
		this.disciplinaTurma = disciplinaTurma;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Disciplina other = (Disciplina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
