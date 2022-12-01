package br.com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.model.Feriado;

@Repository
public interface FeriadoRepository extends JpaRepository<Feriado, Long> { // <Classe, Tipo da Chave Primaria>

}