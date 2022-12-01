package br.com.restaurante.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.Advertencia;
import br.com.restaurante.model.Aluno;

@Repository
public interface AdvertenciaRepository extends JpaRepository<Advertencia, Long> { // <Classe, Tipo da Chave Primaria>

	Optional<List<Advertencia>> findListByAluno(Aluno aluno);
	
	Optional<Advertencia> findByAluno(Aluno aluno);
}
