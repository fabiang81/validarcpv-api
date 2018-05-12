package com.multiva.cecoban.validarcpv.dto.request;

import org.springframework.stereotype.Component;

@Component
public class Ubicacion {
	
	private PosicionSatelital posicionSatelital;
	private Localidad localidad;
	
	public PosicionSatelital getPosicionSatelital() {
		return posicionSatelital;
	}
	public void setPosicionSatelital(PosicionSatelital posicionSatelital) {
		this.posicionSatelital = posicionSatelital;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public String toString() {
		return "Ubicacion [posicionSatelital=" + posicionSatelital + ", localidad=" + localidad + "]";
	}
	
}
