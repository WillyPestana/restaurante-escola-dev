package br.com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.DisciplinaTurma;

@Repository
public interface DisciplinaTurmaRepository  extends JpaRepository<DisciplinaTurma, Long> {
  
}
