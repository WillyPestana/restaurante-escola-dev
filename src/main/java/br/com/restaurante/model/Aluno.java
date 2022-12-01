package br.com.restaurante.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cd_matricula_aluno")
	@NotNull
	private Long matricula;

	@Column(name = "nm_aluno")
	private String nome;
	
	@Column(name = "nm_social")
	private String nomeSocial;

	@Column(name = "cd_idade_aluno")
	private Integer idade;
	
	@Column(name = "nm_estado_civil_aluno")
	private String estadoCivil;

	@Column(name = "dt_nascimento_aluno")
	private LocalDate dataNascimento;
	
	@Column(name = "cd_rg_aluno")
	private String rg;
	
	@Column(name = "cd_cpf_aluno")
	private String cpf;

	@Column(name = "cd_telefone_celular_aluno")
	private String telefoneCelular;
	
	@Column(name = "cd_whatsapp_aluno")
	private String numeroWhatsapp;
	
	@Column(name = "cd_telefone_recado_aluno")
	private String telefoneRecado;
	
	@Column(name = "nm_pessoa_tel_recado_aluno")
	private String nomePessoaTelefoneRecado;
	
	@Column(name = "nm_endereco_aluno")
	private String endereco;

	@Column(name = "nm_email_aluno")
	private String email;
	
	@Column(name = "nm_responsavel_aluno")
	private String nomeResponsavel;
	
	@Column(name = "nm_escolaridade_aluno")
	private String escolaridade;
	
	@Column(name = "nm_escolaridade_grau_aluno")
	private String escolaridadeGrau;
	
	@Column(name = "nm_escola")
	private String escola;
	
	@Column(name = "cd_ano_medio_escolaridade_aluno")
	private String anoMedio;
	
	@Column(name = "cd_ano_formacao_medio_escolaridade_aluno")
	private String anoFormacaoMedio;
	
	@Column(name = "cd_camiseta_aluno")
	private String camiseta;

	@Column(name = "cd_sapato_aluno")
	private String sapato;

	@Column(name = "nm_servico_atendimento_aluno")
	private String servicoAtendimento;
	
	@Column(name = "nm_unidade_aluno")
	private String unidade;
	
	@Column(name = "nm_tecnico_aluno")
	private String tecnico;
	
	@Column(name = "cd_telefone_tecnico_aluno")
	private String telefoneTecnico;

	@Column(name = "ic_alergia_aluno")
	private Boolean alergia;

	@Column(name = "ic_alergia_remedio_aluno")
	private Boolean alergiaRemedio;

	@Column(name = "ic_alergia_alimento_aluno")
	private Boolean alergiaAlimento;

	@Column(name = "ic_alergia_outros_aluno")
	private Boolean alergiaOutros;

	@Column(name = "ds_especificacao_alergia_aluno")
	private String especificacaoAlergia;

	@Column(name = "ic_hipertensao_aluno")
	private Boolean hipertensao;

	@Column(name = "ic_hipotensao_aluno")
	private Boolean hipotensao;

	@Column(name = "ic_epilepsia_aluno")
	private Boolean epilepsia;

	@Column(name = "ic_diabetes_aluno")
	private Boolean diabetes;

	@Column(name = "ic_problema_renal_aluno")
	private Boolean problemaRenal;

	@Column(name = "ic_problema_ocular_aluno")
	private Boolean problemaOcular;

	@Column(name = "ic_problema_respiratorio_aluno")
	private Boolean problemaRespiratorio;

	@Column(name = "ic_fumante_aluno")
	private Boolean fumante;
	
	@Column(name = "ds_medicamentos_uso_continuo")
	private String medicamentosUsoContinuo;

	@Column(name = "ds_obs_aluno")
	private String observacao;

	@Column(name = "dt_criado_em")
	private LocalDate criadoEm  = LocalDate.now();

	@Column(name = "dt_atualizado_em")
	private LocalDate atualizadoEm = LocalDate.now();

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<Advertencia> advertencias;

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<Boletim> boletins;

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<Frequencia> frequencias;
	
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<OcorrenciaDiario> ocorrenciaDiario;

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<AlunoTurma> turma;
	
	//NÃO PODE EXCLUIR O CONSTRUTOR VAZIO
	public Aluno() {}
	
	public Aluno(Long matricula, String nome, String nomeSocial, Integer idade, String estadoCivil,
			LocalDate dataNascimento, String rg, String cpf, String telefoneCelular, String numeroWhatsapp,
			String telefoneRecado, String nomePessoaTelefoneRecado, String endereco, String email,
			String nomeResponsavel, String escolaridade, String escolaridadeGrau, String escola, String anoMedio,
			String anoFormacaoMedio, String camiseta, String sapato, String servicoAtendimento, String unidade,
			String tecnico, String telefoneTecnico, Boolean alergia, Boolean alergiaRemedio, Boolean alergiaAlimento,
			Boolean alergiaOutros, String especificacaoAlergia, Boolean hipertensao, Boolean hipotensao,
			Boolean epilepsia, Boolean diabetes, Boolean problemaRenal, Boolean problemaOcular,
			Boolean problemaRespiratorio, Boolean fumante, String medicamentosUsoContinuo, String observacao) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.idade = idade;
		this.estadoCivil = estadoCivil;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.cpf = cpf;
		this.telefoneCelular = telefoneCelular;
		this.numeroWhatsapp = numeroWhatsapp;
		this.telefoneRecado = telefoneRecado;
		this.nomePessoaTelefoneRecado = nomePessoaTelefoneRecado;
		this.endereco = endereco;
		this.email = email;
		this.nomeResponsavel = nomeResponsavel;
		this.escolaridade = escolaridade;
		this.escola = escola;
		this.anoMedio = anoMedio;
		this.anoFormacaoMedio = anoFormacaoMedio;
		this.camiseta = camiseta;
		this.sapato = sapato;
		this.servicoAtendimento = servicoAtendimento;
		this.unidade = unidade;
		this.tecnico = tecnico;
		this.telefoneTecnico = telefoneTecnico;
		this.alergia = alergia;
		this.alergiaRemedio = alergiaRemedio;
		this.alergiaAlimento = alergiaAlimento;
		this.alergiaOutros = alergiaOutros;
		this.especificacaoAlergia = especificacaoAlergia;
		this.hipertensao = hipertensao;
		this.hipotensao = hipotensao;
		this.epilepsia = epilepsia;
		this.diabetes = diabetes;
		this.problemaRenal = problemaRenal;
		this.problemaOcular = problemaOcular;
		this.problemaRespiratorio = problemaRespiratorio;
		this.fumante = fumante;
		this.medicamentosUsoContinuo = medicamentosUsoContinuo;
		this.observacao = observacao;
		this.escolaridadeGrau = escolaridadeGrau;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getObservacao() {
		return observacao;
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
	
	public String getEscolaridadeGrau() {
		return escolaridadeGrau;
	}

	public void setEscolaridadeGrau(String escolaridadeGrau) {
		this.escolaridadeGrau = escolaridadeGrau;
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

	public List<Boletim> getBoletins() {
		return boletins;
	}

	public void setBoletins(List<Boletim> boletins) {
		this.boletins = boletins;
	}

	public List<Frequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<OcorrenciaDiario> getOcorrenciaDiario() {
		return ocorrenciaDiario;
	}

	public void setOcorrenciaDiario(List<OcorrenciaDiario> ocorrenciaDiario) {
		this.ocorrenciaDiario = ocorrenciaDiario;
	}

	public List<AlunoTurma> getTurma() {
		return turma;
	}

	public void setTurma(List<AlunoTurma> turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() { 
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}
