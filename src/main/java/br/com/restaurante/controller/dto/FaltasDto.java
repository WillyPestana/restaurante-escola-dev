package br.com.restaurante.controller.dto;

import java.util.List;

public class FaltasDto {

	private List<FrequenciaDto> frequencias;
	
	private Integer quantidadeFaltas;

	public List<FrequenciaDto> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<FrequenciaDto> frequencias) {
		this.frequencias = frequencias;
	}

	public Integer getQuantidadeFaltas() {
		return quantidadeFaltas;
	}

	public void setQuantidadeFaltas(Integer quantidadeFaltas) {
		this.quantidadeFaltas = quantidadeFaltas;
	}
	
	public FaltasDto(Integer quantiadeFaltas, List<FrequenciaDto> frequencias) {
		this.quantidadeFaltas = quantiadeFaltas;
		this.frequencias = frequencias;
	}

	public static FaltasDto converter(int quantiadeFaltas, List<FrequenciaDto> frequencias) {
		return new FaltasDto(Integer.valueOf(quantiadeFaltas), frequencias);
	}

}
