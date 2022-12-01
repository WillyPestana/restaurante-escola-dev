package br.com.restaurante.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.restaurante.model.Feriado;

public class FeriadoDto {
	
	//botar o codigo do feriado no dto
	
	private LocalDate data;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public FeriadoDto(Feriado feriado) {
		this.data = feriado.getData();
	}

	public static List<FeriadoDto> converter(List<Feriado> feriados) {
		return feriados.stream().map(feriado -> new FeriadoDto(feriado)).collect(Collectors.toList());
	}

	public static FeriadoDto converter(Feriado feriado) {
		return new FeriadoDto(feriado);
	}

}
