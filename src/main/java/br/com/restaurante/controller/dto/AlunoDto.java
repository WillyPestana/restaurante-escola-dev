package br.com.restaurante.controller.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.restaurante.model.Advertencia;
import br.com.restaurante.model.Aluno;
import br.com.restaurante.model.Frequencia;
import br.com.restaurante.model.OcorrenciaDiario;

//classe apenas para representar o que devolvemos pro cliente por JSON
public class AlunoDto {
	
	//colocar atributos que devolvemos pro cliente
	
	private Long matricula;
	
	private String nome;
	
	private String nomeSocial;

	private Integer idade;
	
	private String estadoCivil;

	private LocalDate dataNascimento;
	
	private String rg;
	
	private String cpf;

	private String telefoneCelular;
	
	private String numeroWhatsapp;
	
	private String telefoneRecado;
	
	private String nomePessoaTelefoneRecado;
	
	private String endereco;

	private String email;
	
	private String nomeResponsavel;
	
	private String escolaridade;
	
	private String escolaridadeGrau;
	
	private String escola;
	
	private String anoMedio;
	
	private String anoFormacaoMedio;
	
	private String camiseta;

	private String sapato;

	private String servicoAtendimento;
	
	private String unidade;
	
	private String tecnico;
	
	private String telefoneTecnico;

	private Boolean alergia;

	private Boolean alergiaRemedio;

	private Boolean alergiaAlimento;

	private Boolean alergiaOutros;

	private String especificacaoAlergia;

	private Boolean hipertensao;

	private Boolean hipotensao;

	private Boolean epilepsia;

	private Boolean diabetes;

	private Boolean problemaRenal;

	private Boolean problemaOcular;

	private Boolean problemaRespiratorio;

	private Boolean fumante;
	
	private String medicamentosUsoContinuo;

	private String observacao;

	private LocalDate criadoEm;

	private LocalDate atualizadoEm;
	
	private List<Advertencia> advertencias = new ArrayList<Advertencia>();
	
	private List<Frequencia> frequencias = new ArrayList<Frequencia>();
	
	private List<OcorrenciaDiario> ocorrenciaDiario = new ArrayList<OcorrenciaDiario>();
	
	private Integer numeroTurma;

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getNumeroWhatsapp() {
		return numeroWhatsapp;
	}

	public void setNumeroWhatsapp(String numeroWhatsapp) {
		this.numeroWhatsapp = numeroWhatsapp;
	}

	public String getTelefoneRecado() {
		return telefoneRecado;
	}

	public void setTelefoneRecado(String telefoneRecado) {
		this.telefoneRecado = telefoneRecado;
	}

	public String getNomePessoaTelefoneRecado() {
		return nomePessoaTelefoneRecado;
	}

	public void setNomePessoaTelefoneRecado(String nomePessoaTelefoneRecado) {
		this.nomePessoaTelefoneRecado = nomePessoaTelefoneRecado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public String getAnoMedio() {
		return anoMedio;
	}

	public void setAnoMedio(String anoMedio) {
		this.anoMedio = anoMedio;
	}

	public String getAnoFormacaoMedio() {
		return anoFormacaoMedio;
	}

	public void setAnoFormacaoMedio(String anoFormacaoMedio) {
		this.anoFormacaoMedio = anoFormacaoMedio;
	}

	public String getCamiseta() {
		return camiseta;
	}

	public void setCamiseta(String camiseta) {
		this.camiseta = camiseta;
	}

	public String getSapato() {
		return sapato;
	}

	public void setSapato(String sapato) {
		this.sapato = sapato;
	}

	public String getServicoAtendimento() {
		return servicoAtendimento;
	}

	public void setServicoAtendimento(String servicoAtendimento) {
		this.servicoAtendimento = servicoAtendimento;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getTelefoneTecnico() {
		return telefoneTecnico;
	}

	public void setTelefoneTecnico(String telefoneTecnico) {
		this.telefoneTecnico = telefoneTecnico;
	}

	public Boolean getAlergia() {
		return alergia;
	}

	public void setAlergia(Boolean alergia) {
		this.alergia = alergia;
	}

	public Boolean getAlergiaRemedio() {
		return alergiaRemedio;
	}

	public void setAlergiaRemedio(Boolean alergiaRemedio) {
		this.alergiaRemedio = alergiaRemedio;
	}

	public Boolean getAlergiaAlimento() {
		return alergiaAlimento;
	}

	public void setAlergiaAlimento(Boolean alergiaAlimento) {
		this.alergiaAlimento = alergiaAlimento;
	}

	public Boolean getAlergiaOutros() {
		return alergiaOutros;
	}

	public void setAlergiaOutros(Boolean alergiaOutros) {
		this.alergiaOutros = alergiaOutros;
	}

	public String getEspecificacaoAlergia() {
		return especificacaoAlergia;
	}

	public void setEspecificacaoAlergia(String especificacaoAlergia) {
		this.especificacaoAlergia = especificacaoAlergia;
	}

	public Boolean getHipertensao() {
		return hipertensao;
	}

	public void setHipertensao(Boolean hipertensao) {
		this.hipertensao = hipertensao;
	}

	public Boolean getHipotensao() {
		return hipotensao;
	}

	public void setHipotensao(Boolean hipotensao) {
		this.hipotensao = hipotensao;
	}

	public Boolean getEpilepsia() {
		return epilepsia;
	}

	public void setEpilepsia(Boolean epilepsia) {
		this.epilepsia = epilepsia;
	}

	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

	public Boolean getProblemaRenal() {
		return problemaRenal;
	}

	public void setProblemaRenal(Boolean problemaRenal) {
		this.problemaRenal = problemaRenal;
	}

	public Boolean getProblemaOcular() {
		return problemaOcular;
	}

	public void setProblemaOcular(Boolean problemaOcular) {
		this.problemaOcular = problemaOcular;
	}

	public Boolean getProblemaRespiratorio() {
		return problemaRespiratorio;
	}

	public void setProblemaRespiratorio(Boolean problemaRespiratorio) {
		this.problemaRespiratorio = problemaRespiratorio;
	}

	public Boolean getFumante() {
		return fumante;
	}

	public void setFumante(Boolean fumante) {
		this.fumante = fumante;
	}

	public String getMedicamentosUsoContinuo() {
		return medicamentosUsoContinuo;
	}

	public void setMedicamentosUsoContinuo(String medicamentosUsoContinuo) {
		this.medicamentosUsoContinuo = medicamentosUsoContinuo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservasao(String observacao) {
		this.observacao = observacao;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}

	public LocalDate getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(LocalDate atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}
	
	public List<Advertencia> getAdvertencias() {
		return advertencias;
	}

	public void setAdvertencias(List<Advertencia> advertencias) {
		this.advertencias = advertencias;
	}

	public List<Frequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}

	public List<OcorrenciaDiario> getOcorrenciaDiario() {
		return ocorrenciaDiario;
	}

	public void setOcorrenciaDiario(List<OcorrenciaDiario> ocorrenciaDiario) {
		this.ocorrenciaDiario = ocorrenciaDiario;
	}

	public Integer getNumeroTurma() {
		return numeroTurma;
	}

	public void setNumeroTurma(Integer numeroTurma) {
		this.numeroTurma = numeroTurma;
	}
	
	public String getEscolaridadeGrau() {
		return escolaridadeGrau;
	}

	public void setEscolaridadeGrau(String escolaridadeGrau) {
		this.escolaridadeGrau = escolaridadeGrau;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public AlunoDto(Aluno aluno) {
		this.matricula = aluno.getMatricula();
		this.nome = aluno.getNome();
		this.nomeSocial = aluno.getNomeSocial();
		this.idade = aluno.getIdade();
		this.estadoCivil = aluno.getEstadoCivil();
		this.dataNascimento = aluno.getDataNascimento();
		this.rg = aluno.getRg();
		this.cpf = aluno.getCpf();
		this.telefoneCelular = aluno.getTelefoneCelular();
		this.numeroWhatsapp = aluno.getNumeroWhatsapp();
		this.telefoneRecado = aluno.getTelefoneRecado();
		this.nomePessoaTelefoneRecado = aluno.getNomePessoaTelefoneRecado();
		this.endereco = aluno.getEndereco();
		this.email = aluno.getEmail();
		this.nomeResponsavel = aluno.getNomeResponsavel();
		this.escolaridade = aluno.getEscolaridade();
		this.escola = aluno.getEscola();
		this.anoMedio = aluno.getAnoMedio();
		this.anoFormacaoMedio = aluno.getAnoFormacaoMedio();
		this.camiseta = aluno.getCamiseta();
		this.sapato = aluno.getSapato();
		this.servicoAtendimento = aluno.getServicoAtendimento();
		this.unidade = aluno.getUnidade();
		this.tecnico = aluno.getTecnico();
		this.telefoneTecnico = aluno.getTelefoneTecnico();
		this.alergia = aluno.getAlergia();
		this.alergiaRemedio = aluno.getAlergiaRemedio();
		this.alergiaAlimento = aluno.getAlergiaAlimento();
		this.alergiaOutros = aluno.getAlergiaOutros();
		this.especificacaoAlergia = aluno.getEspecificacaoAlergia();
		this.hipertensao = aluno.getHipertensao();
		this.hipotensao = aluno.getHipotensao();
		this.epilepsia = aluno.getEpilepsia();
		this.diabetes = aluno.getDiabetes();
		this.problemaRenal = aluno.getProblemaRenal();
		this.problemaOcular = aluno.getProblemaOcular();
		this.problemaRespiratorio = aluno.getProblemaRespiratorio();
		this.fumante = aluno.getFumante();
		this.medicamentosUsoContinuo = aluno.getMedicamentosUsoContinuo();
		this.observacao = aluno.getObservacao();
		this.criadoEm = aluno.getCriadoEm();
		this.atualizadoEm = aluno.getAtualizadoEm();
		this.advertencias = aluno.getAdvertencias();
		this.frequencias = aluno.getFrequencias();
		this.ocorrenciaDiario = aluno.getOcorrenciaDiario();
		if (aluno.getTurma().size() == 0) {
			this.numeroTurma = null;
		} else {
			this.numeroTurma = aluno.getTurma().get(aluno.getTurma().size() - 1).getTurma().getNumero();
		}
	}

	public static List<AlunoDto> converter(List<Aluno> alunos) {
		return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}

	public static AlunoDto converter(Aluno aluno) {
		return new AlunoDto(aluno);
	}

}
