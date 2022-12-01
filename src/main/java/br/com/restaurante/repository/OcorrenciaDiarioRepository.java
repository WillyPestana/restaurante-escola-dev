package br.com.restaurante.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.Aluno;
import br.com.restaurante.model.OcorrenciaDiario;

@Repository
public interface OcorrenciaDiarioRepository extends JpaRepository<OcorrenciaDiario, Long> { // <Classe, Tipo da Chave Primaria>

	Optional<List<OcorrenciaDiario>> findListByAluno(Aluno aluno);
	
	Optional<OcorrenciaDiario> findByAluno(Aluno aluno);
}