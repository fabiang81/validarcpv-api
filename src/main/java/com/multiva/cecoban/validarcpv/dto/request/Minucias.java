package com.multiva.cecoban.validarcpv.dto.request;

public class Minucias {
	
	private String tipo;
	private int ancho;
	private int alto;
	private int dedo;
	private String minucia;
	
	private Minucias(Builder builder) {
		this.tipo = builder.tipo;
		this.ancho = builder.ancho;
		this.alto = builder.alto;
		this.dedo = builder.dedo;
		this.minucia = builder.minucia;
	}
	
	public String getTipo() {
		return tipo;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public int getDedo() {
		return dedo;
	}

	public String getMinucia() {
		return minucia;
	}

	@Override
	public String toString() {
		return "Minucias [tipo=" + tipo + ", ancho=" + ancho + ", alto=" + alto + ", dedo=" + dedo + ", minucia="
				+ minucia + "]";
	}

	public static class Builder {
		
		private String tipo;
		private int ancho;
		private int alto;
		private int dedo;
		private String minucia;
		
		public Builder tipo(String tipo) {
			this.tipo = tipo;
			return this;
		}
		
		public Builder ancho(int ancho) {
			this.ancho = ancho;
			return this;
		}
		
		public Builder alto(int alto) {
			this.alto = alto;
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
