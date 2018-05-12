package com.multiva.cecoban.validarcpv.dto.request;

import org.springframework.stereotype.Component;

@Component
public class Localidad {
	
	private String codigoPostal;
	private String ciudad;
	private int estado;
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Localidad [codigoPostal=" + codigoPostal + ", ciudad=" + ciudad + ", estado=" + estado + "]";
	}	

}
