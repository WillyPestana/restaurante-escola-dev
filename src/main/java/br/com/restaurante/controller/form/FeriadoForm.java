package br.com.restaurante.controller.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;

import br.com.restaurante.model.Feriado;

public class FeriadoForm {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@NotNull
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Feriado converter() {
		return new Feriado(LocalDate.parse(data, formatter));
	}

}
