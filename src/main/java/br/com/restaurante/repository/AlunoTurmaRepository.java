package br.com.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.AlunoTurma;

@Repository
public interface AlunoTurmaRepository extends JpaRepository<AlunoTurma, Long> {
  
	List<AlunoTurma> findByTurma_Numero(Integer i);

}
