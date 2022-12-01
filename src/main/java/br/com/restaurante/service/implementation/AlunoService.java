package br.com.restaurante.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.model.Aluno;
import br.com.restaurante.model.AlunoTurma;
import br.com.restaurante.repository.AlunoRepository;
import br.com.restaurante.repository.AlunoTurmaRepository;
import br.com.restaurante.service.InterfaceService;

@Service
public class AlunoService implements InterfaceService<Aluno> {

	@Autowired
	public AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoTurmaRepository alunoTurmaRepository;

	@Override
	@Transactional
	public Aluno create(Aluno aluno) {
		alunoRepository.save(aluno);
		return aluno;
	}

	@Override
	public Aluno findById(Long matricula) {
		Optional<Aluno> _aluno = alunoRepository.findById(matricula);
		return _aluno.orElse(null);
	}
	
	public List<Aluno> findByNome(String nome) {
		Optional<List<Aluno>> _aluno = alunoRepository.findByNomeLike("%"+nome+"%");
		return _aluno.orElse(null);
	}


	@Override
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Override
	@Transactional
	public boolean update(Aluno aluno) {
		if (alunoRepository.existsById(aluno.getMatricula())) {
			aluno.setAtualizadoEm(LocalDate.now());
			alunoRepository.save(aluno);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean delete(Long matricula) {
		if (alunoRepository.existsById(matricula)) {
			alunoRepository.deleteById(matricula);
			return true;
		}
		return false;
	}

	public List<Aluno> findByTurma(String codigoTurma) {
		// TEM QUE IMPLEMENTAR (talvez use o repositoy do AlunoTurma)
		
		//MELHORAR IMPLEMENTACAO
		
		//se der problema no parse, mudar o json para receber um integer
		List<AlunoTurma> list = alunoTurmaRepository.findByTurma_Numero(Integer.valueOf(codigoTurma));
		
		if(list.isEmpty()) {
			return null;
		}
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		for (AlunoTurma alunoTurma : list) {
			alunos.add(alunoTurma.getAluno());
		}
		return alunos;
	}
}
