package com.multiva.cecoban.validarcpv.dto.response;

import org.springframework.stereotype.Component;

@Component
public class TimeStamp {
	
	private String momento;
	private String indice;
	private String numeroSerie;
	
	public String getMomento() {
		return momento;
	}
	public void setMomento(String momento) {
		this.momento = momento;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	@Override
	public String toString() {
		return "TimeStamp [momento=" + momento + ", indice=" + indice + ", numeroSerie=" + numeroSerie + "]";
	}
	
}
