package com.multiva.cecoban.validarcpv.dto.request;

public class Ubicacion {
	
	private Localidad localidad;
	private PosicionSatelital posicionSatelital;
	
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public PosicionSatelital getPosicionSatelital() {
		return posicionSatelital;
	}
	public void setPosicionSatelital(PosicionSatelital posicionSatelital) {
		this.posicionSatelital = posicionSatelital;
	}

}
