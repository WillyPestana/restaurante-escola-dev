package br.com.restaurante.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.model.Feriado;
import br.com.restaurante.repository.FeriadoRepository;
import br.com.restaurante.service.InterfaceService;

@Service
public class FeriadoService implements InterfaceService<Feriado>{

	@Autowired
	private FeriadoRepository repository;
	
	@Override
	@Transactional
	public Feriado create(Feriado feriado) {
		repository.save(feriado);
		return feriado;
	}

	@Override
	public Feriado findById(Long codigo) {
		Optional<Feriado> _feriado = repository.findById(codigo);
		return _feriado.orElse(null);
	}

	@Override
	public List<Feriado> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public boolean update(Feriado feriado) {
		if (repository.existsById(feriado.getCodigo())) {
			feriado.setAtualizadoEm(LocalDate.now());
			repository.save(feriado);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean delete(Long codigo) {
		if (repository.existsById(codigo)) {
			repository.deleteById(codigo);
			return true;
		}
		return false;
	}
}
