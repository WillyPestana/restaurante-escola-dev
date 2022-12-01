package br.com.restaurante.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.model.Aluno;
import br.com.restaurante.model.OcorrenciaDiario;
import br.com.restaurante.repository.OcorrenciaDiarioRepository;
import br.com.restaurante.service.InterfaceService;

@Service
public class OcorrenciaDiarioService implements InterfaceService<OcorrenciaDiario> {
	
	@Autowired
	private OcorrenciaDiarioRepository ocorrenciaDiarioRepository;

	@Override
	@Transactional
	public OcorrenciaDiario create(OcorrenciaDiario ocorrenciaDiario) {
		ocorrenciaDiarioRepository.save(ocorrenciaDiario);
		return ocorrenciaDiario;
	}

	@Override
	public OcorrenciaDiario findById(Long codigo) {
		Optional<OcorrenciaDiario> _OcorrenciaDiario = ocorrenciaDiarioRepository.findById(codigo);
		return _OcorrenciaDiario.orElse(null);
	}
	
	public OcorrenciaDiario findByAluno(Aluno aluno) {
		Optional<OcorrenciaDiario> _OcorrenciaDiario = ocorrenciaDiarioRepository.findByAluno(aluno);
		return _OcorrenciaDiario.orElse(null);
	}
	
	public List<OcorrenciaDiario> findListByAluno(Aluno aluno) {
		Optional<List<OcorrenciaDiario>> _OcorrenciaDiario = ocorrenciaDiarioRepository.findListByAluno(aluno);
		return _OcorrenciaDiario.orElse(new ArrayList<OcorrenciaDiario>());
	}

	@Override
	public List<OcorrenciaDiario> findAll() {
		return ocorrenciaDiarioRepository.findAll();
	}

	@Override
	@Transactional
	public boolean update(OcorrenciaDiario ocorrenciaDiario) {
		if (ocorrenciaDiarioRepository.existsById(ocorrenciaDiario.getCodigo())) {
			ocorrenciaDiario.setAtualizadoEm(LocalDate.now());
			ocorrenciaDiarioRepository.save(ocorrenciaDiario);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean delete(Long codigo) {
		if (ocorrenciaDiarioRepository.existsById(codigo)) {
			ocorrenciaDiarioRepository.deleteById(codigo);
			return true;
		}
		return false;
	}
}
