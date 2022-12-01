package br.com.restaurante.service.implementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.model.Frequencia;
import br.com.restaurante.repository.FrequenciaAlunoRepository;
import br.com.restaurante.service.InterfaceService;

@Service
public class FrequenciaService implements InterfaceService<Frequencia> {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Autowired
	private FrequenciaAlunoRepository frequenciaRepository;

	@Override
	@Transactional
	public Frequencia create(Frequencia frequencia) {
		frequenciaRepository.save(frequencia);
		return frequencia;
	}

	@Override
	public Frequencia findById(Long id) {
		Optional<Frequencia> _Frequencia = frequenciaRepository.findById(id);
		return _Frequencia.orElse(null);
	}
	
	public List<Frequencia> findByData(String data, Integer numero) {
		Optional<List<Frequencia>> _Frequencia = frequenciaRepository.findByDataAulaAndTurma_Numero(LocalDate.parse(data,formatter), numero);
		return _Frequencia.orElse(null);
	}

	@Override
	public List<Frequencia> findAll() {
		return frequenciaRepository.findAll();
	}

	@Override
	@Transactional
	public boolean update(Frequencia frequencia) {
		if (frequenciaRepository.existsById(frequencia.getCodigo())) {
			frequencia.setAtualizadoEm(LocalDate.now());
			frequenciaRepository.save(frequencia);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean delete(Long id) {
		if (frequenciaRepository.existsById(id)) {
			frequenciaRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
