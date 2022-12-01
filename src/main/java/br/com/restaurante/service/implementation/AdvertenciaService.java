package br.com.restaurante.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.model.Advertencia;
import br.com.restaurante.model.Aluno;
import br.com.restaurante.repository.AdvertenciaRepository;
import br.com.restaurante.service.InterfaceService;

@Service
public class AdvertenciaService implements InterfaceService<Advertencia>{

	@Autowired
	private AdvertenciaRepository advertenciaRepository;

	@Override
	@Transactional
	public Advertencia create(Advertencia advertencia) {
		advertenciaRepository.save(advertencia);
		return advertencia;
	}

	@Override
	public Advertencia findById(Long codigo) {
		Optional<Advertencia> _Advertencia = advertenciaRepository.findById(codigo);
		return _Advertencia.orElse(null);
	}
	
	public Advertencia findByAluno(Aluno aluno) {
		Optional<Advertencia> _Advertencia = advertenciaRepository.findByAluno(aluno);
		return _Advertencia.orElse(null);
	}
	
	public List<Advertencia> findListByAluno(Aluno aluno) {
		Optional<List<Advertencia>> _Advertencia = advertenciaRepository.findListByAluno(aluno);
		return _Advertencia.orElse(new ArrayList<Advertencia>());
	}

	@Override
	public List<Advertencia> findAll() {
		return advertenciaRepository.findAll();
	}

	@Override
	@Transactional
	public boolean update(Advertencia Advertencia) {
		if (advertenciaRepository.existsById(Advertencia.getCodigo())) {
			Advertencia.setAtualizadoEm(LocalDate.now());
			advertenciaRepository.save(Advertencia);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean delete(Long codigo) {
		if (advertenciaRepository.existsById(codigo)) {
			advertenciaRepository.deleteById(codigo);
			return true;
		}
		return false;
	}

}
