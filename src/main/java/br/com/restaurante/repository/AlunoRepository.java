package br.com.restaurante.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> { // <Classe, Tipo da Chave Primaria>

	Optional<List<Aluno>> findByNomeLike(String nome);
	
}
