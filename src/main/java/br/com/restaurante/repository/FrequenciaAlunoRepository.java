package br.com.restaurante.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.Frequencia;

@Repository
public interface FrequenciaAlunoRepository extends JpaRepository<Frequencia, Long> { // <Classe, Tipo da Chave Primaria>

	Optional<List<Frequencia>> findByDataAulaAndTurma_Numero(LocalDate data, Integer numero);
}