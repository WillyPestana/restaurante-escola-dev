package br.com.restaurante.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.restaurante.model.OcorrenciaDiario;

public class OcorrenciaDiarioDto {
	
	private Long codigo;
	
	private String matricula;

	private String descricao;

	private String data;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public OcorrenciaDiarioDto(OcorrenciaDiario ocorrenciaDiario) {
		this.codigo = ocorrenciaDiario.getCodigo();
		this.matricula = ocorrenciaDiario.getAluno().getMatricula().toString(); 
		//pode dar problema no parse do long para string
		//se der, mudar a matricula no json para long
		this.descricao = ocorrenciaDiario.getOcorrencia();
		this.data = ocorrenciaDiario.getDataOcorrencia().toString();
	}

	public static List<OcorrenciaDiarioDto> converter(List<OcorrenciaDiario> listaOcorrenciaDiario) {
		return listaOcorrenciaDiario.stream().map(ocorrenciaDiario -> new OcorrenciaDiarioDto(ocorrenciaDiario)).collect(Collectors.toList());
	}

	public static OcorrenciaDiarioDto converter(OcorrenciaDiario ocorrenciaDiario) {
		return new OcorrenciaDiarioDto(ocorrenciaDiario);
	}
}
