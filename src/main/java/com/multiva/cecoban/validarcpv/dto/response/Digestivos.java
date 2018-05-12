package com.multiva.cecoban.validarcpv.dto.response;

import org.springframework.stereotype.Component;

@Component
public class Digestivos {
	
	private String digEntradaDatos;
	private String digSalidaDatos;
	private String digTimestamp;
	
	public String getDigEntradaDatos() {
		return digEntradaDatos;
	}
	public void setDigEntradaDatos(String digEntradaDatos) {
		this.digEntradaDatos = digEntradaDatos;
	}
	public String getDigSalidaDatos() {
		return digSalidaDatos;
	}
	public void setDigSalidaDatos(String digSalidaDatos) {
		this.digSalidaDatos = digSalidaDatos;
	}
	public String getDigTimestamp() {
		return digTimestamp;
	}
	public void setDigTimestamp(String digTimestamp) {
		this.digTimestamp = digTimestamp;
	}
	
	@Override
	public String toString() {
		return "Digestivos [digEntradaDatos=" + digEntradaDatos + ", digSalidaDatos=" + digSalidaDatos
				+ ", digTimestamp=" + digTimestamp + "]";
	}

}
