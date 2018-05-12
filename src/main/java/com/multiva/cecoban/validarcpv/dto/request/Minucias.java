package com.multiva.cecoban.validarcpv.dto.request;

public class Minucias {
	
	private int ancho;
	private int alto;
	private String tipo;
	private int dedo;
	private String minucia;
	
	private Minucias(Builder builder) {
		this.ancho = builder.ancho;
		this.alto = builder.alto;
		this.tipo = builder.tipo;
		this.dedo = builder.dedo;
		this.minucia = builder.minucia;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	public String getTipo() {
		return tipo;
	}

	public int getDedo() {
		return dedo;
	}

	public String getMinucia() {
		return minucia;
	}

	@Override
	public String toString() {
		return "Minucias [ancho=" + ancho + ", alto=" + alto + ", tipo=" + tipo + ", dedo=" + dedo + ", minucia="
				+ minucia + "]";
	}

	public static class Builder {
		
		private int ancho;
		private int alto;
		private String tipo;
		private int dedo;
		private String minucia;
		
		public Builder ancho(int ancho) {
			this.ancho = ancho;
			return this;
		}
		
		public Builder alto(int alto) {
			this.alto = alto;
			return this;
		}
		
		public Builder tipo(String tipo) {
			this.tipo = tipo;
			return this;
		}
		
		public Builder dedo(int dedo) {
			this.dedo = dedo;
			return this;
		}
		
		public Builder minucia(String minucia) {
			this.minucia = minucia;
			return this;
		}
		
		public Minucias build() {
			return new Minucias(this);
		}
	}

}
