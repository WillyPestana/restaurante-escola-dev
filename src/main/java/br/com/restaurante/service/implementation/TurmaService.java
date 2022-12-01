package br.com.restaurante.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.model.Aluno;
import br.com.restaurante.model.AlunoTurma;
import br.com.restaurante.model.Turma;
import br.com.restaurante.repository.AlunoTurmaRepository;
import br.com.restaurante.repository.TurmaRepository;
import br.com.restaurante.service.InterfaceService;

@Service
public class TurmaService implements InterfaceService<Turma> {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private AlunoTurmaRepository alunoTurmaRepository;
	
	@Autowired
	private AlunoService alunoService;

	@Override
	@Transactional
	public Turma create(Turma turma) {
		turmaRepository.save(turma);
		return turma;
	}

	@Override
	public Turma findById(Long codigo) {
		Optional<Turma> _Turma = turmaRepository.findById(codigo);
		return _Turma.orElse(null);
	}
	
	public Turma findByCodigoTurma(Integer codigo) {
		Optional<Turma> _Turma = turmaRepository.findByNumero(codigo);
		return _Turma.orElse(null);
	}

	@Override
	public List<Turma> findAll() {
		return turmaRepository.findAll(); 
	}

	public List<Aluno> findAlunos(Integer codigo) {
		List<AlunoTurma> listAlunoTurma = alunoTurmaRepository.findByTurma_Numero(codigo);
		return listAlunoTurma.stream().map(c -> c.getAluno()).collect(Collectors.toList());
		
	}
	
	@Override
	@Transactional
	public boolean update(Turma turma) {
		if (turmaRepository.existsById(turma.getCodigo())) {
			turma.setAtualizadoEm(LocalDate.now());
			turmaRepository.save(turma);
			return true;
		}
		return false;
	}

	@Transactional
	public boolean delete(Integer codigo) {
		Optional<Turma> turma = turmaRepository.findByNumero(codigo);
		if (turma.isPresent()) {
			turmaRepository.deleteById(turma.get().getCodigo());
			return true;
		}
		return false;
	}

	@Transactional
	public AlunoTurma cadastrarAlunoTurma(AlunoTurma alunoTurma) {
		alunoTurmaRepository.save(alunoTurma);
		this.update(alunoTurma.getTurma());
		alunoService.update(alunoTurma.getAluno());
		return alunoTurma;
	}

	
	@Override
	public boolean delete(Long id) {
		return false;
	}
}
