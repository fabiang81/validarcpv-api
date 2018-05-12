package com.multiva.cecoban.validarcpv.dto.request;

import org.springframework.stereotype.Component;

@Component
public class PosicionSatelital {
	
	private float latitud;
	private float longitud;
	
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
	@Override
	public String toString() {
		return "PosicionSatelital [latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
}
