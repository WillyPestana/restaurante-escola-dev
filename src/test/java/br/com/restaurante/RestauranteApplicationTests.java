package br.com.restaurante;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.restaurante.model.Aluno;
import br.com.restaurante.model.Turma;
import br.com.restaurante.model.Advertencia;
import br.com.restaurante.service.implementation.AlunoService;
import br.com.restaurante.service.implementation.TurmaService;
import br.com.restaurante.service.implementation.AdvertenciaService;

@RunWith(SpringRunner.class)
@SpringBootTest 
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //informamos ao spring que é pra usar o banco de dados do aplication properties usado (por padrão, ele sempre utiliza algum banco em memoria)
class RestauranteApplicationTests {
	
	@Autowired
	private AlunoService service;
	@Autowired
	private TurmaService TurmaService;
	@Autowired
	private AdvertenciaService AdvertenciaService;
	
	private Aluno aluno = new Aluno(345749287L, "João Pedro", "João", 15, "Solteiro", LocalDate.now(), "213512353", "42352362313", "13982675622", "13982675622", "13982675622", "Casimiro", "Médio", "Segundo", "Liceu", "1 ano", "2030", "G", "45", "UNIMED", "gonzaga", "amanda", "0800329824", "3423423", "88273023", "4234234", false, false, false, false, "nenhum", false, false, false, false, false, false, false, false, "nenhum", "nenhum");
	private Turma turma = new Turma(444L, 444, LocalDate.now(),LocalDate.of(2023,11,16));
	private Advertencia advertencia = new Advertencia(aluno,"bateu no amiguinho",LocalDate.now());
	
	@Test
	public void crud() {
		create();
		read();
		update();
		delete();
	}
	
	@Test
	public void crudClass() {
		createClass();
		readClass();
		updateClass();
		deleteClass();
		}

	public void create() {
		Aluno alunoCriado = service.create(aluno);
		Assert.assertNotNull(alunoCriado);
	}

	public void read() {
		Aluno alunoBuscado = service.findById(345749287L);
		Assert.assertNotNull(alunoBuscado);
	}

	public void update() {
		aluno.setNome("Teste Aluno");
		boolean update = service.update(aluno);
		Assert.assertTrue(update);
	}

	public void delete() {
		boolean delete = service.delete(345749287L);
		Assert.assertTrue(delete);
	}
	
	
	public void createClass() {
		Turma turmaCriada = TurmaService.create(turma);
		Assert.assertNotNull(turmaCriada);
	}
	
	
	public void readClass() {
		Turma turmaBuscada = TurmaService.findByCodigoTurma(444);
		Assert.assertNotNull(turmaBuscada);
	}
	
	
	public void updateClass() {
		turma.setFimTurma(LocalDate.of(2023,10,16));
		boolean turmaUpdated = TurmaService.update(turma);
		Assert.assertNotNull(turmaUpdated);
	}
	
	
	public void deleteClass() {
		boolean turmaDeleted = TurmaService.delete(444);
		Assert.assertTrue(turmaDeleted);
	}
	
	public void createAdvertencia() {
		Advertencia AdvertenciaCriada = AdvertenciaService.create(advertencia);
		Assert.assertNotNull(AdvertenciaCriada);
	}
}