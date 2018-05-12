package com.multiva.cecoban.validarcpv.dto.request;

import java.util.List;

public class Request {
	
	private Encabezado encabezado;
	private Datos datos;
	private Ubicacion ubicacion;
	private int consentimiento;
	private List<Minucias> minucias;
	
	private Request(Builder builder) {
		this.encabezado = builder.encabezado;
		this.datos = builder.datos;
		this.ubicacion = builder.ubicacion;
		this.consentimiento = builder.consentimiento;
		this.minucias = builder.minucias;
	}
	
	public Encabezado getEncabezado() {
		return encabezado;
	}

	public Datos getDatos() {
		return datos;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public int getConsentimiento() {
		return consentimiento;
	}

	public List<Minucias> getMinucias() {
		return minucias;
	}
	
	@Override
	public String toString() {
		return "Request [encabezado=" + encabezado + ", datos=" + datos + ", ubicacion=" + ubicacion
				+ ", consentimiento=" + consentimiento + ", minucias=" + minucias + "]";
	}

	public static class Builder{
		
		private Encabezado encabezado;
		private Datos datos;
		private Ubicacion ubicacion;
		private int consentimiento;
		private List<Minucias> minucias;
		
		public Builder encabezado(Encabezado encabezado) {
			this.encabezado = encabezado;
			return this;
		}
		
		public Builder datos(Datos datos) {
			this.datos = datos;
			return this;
		}
		
		public Builder ubicacion(Ubicacion ubicacion) {
			this.ubicacion = ubicacion;
			return this;
		}
		
		public Builder consentimiento(int consentimiento) {
			this.consentimiento = consentimiento;
			return this;
		}
		
		public Builder minucias(List<Minucias> minucias) {
			this.minucias = minucias;
			return this;
		}
		
		public Request build() {
			return new Request(this);
		}
		
	}

}
