package com.multiva.cecoban.validarcpv.dto.response;

public class RespuestaComparacion {
	
	private Integer codigoRespuestaDatos;
	private boolean ocr;
	private boolean cic;
	private boolean nombre;
	private boolean apellidoPaterno;
	private boolean apellidoMaterno;
	private boolean anioRegistro;
	private boolean anioEmision;
	private boolean numeroEmisionCredencial;
	private boolean claveElector;
	private boolean curp;
	
	private RespuestaComparacion(Builder builder) {
		this.codigoRespuestaDatos = builder.codigoRespuestaDatos;
		this.ocr = builder.ocr;
		this.cic = builder.cic;
		this.nombre = builder.nombre;
		this.apellidoPaterno = builder.apellidoPaterno;
		this.apellidoMaterno = builder.apellidoMaterno;
		this.anioRegistro = builder.anioRegistro;
		this.anioEmision = builder.anioEmision;
		this.numeroEmisionCredencial = builder.numeroEmisionCredencial;
		this.claveElector = builder.claveElector;
		this.curp = builder.curp;
	}
	
	public Integer getCodigoRespuestaDatos() {
		return codigoRespuestaDatos;
	}

	public boolean isOcr() {
		return ocr;
	}

	public boolean isCic() {
		return cic;
	}

	public boolean isNombre() {
		return nombre;
	}

	public boolean isApellidoPaterno() {
		return apellidoPaterno;
	}

	public boolean isApellidoMaterno() {
		return apellidoMaterno;
	}

	public boolean isAnioRegistro() {
		return anioRegistro;
	}

	public boolean isAnioEmision() {
		return anioEmision;
	}

	public boolean isNumeroEmisionCredencial() {
		return numeroEmisionCredencial;
	}

	public boolean isClaveElector() {
		return claveElector;
	}

	public boolean isCurp() {
		return curp;
	}

	@Override
	public String toString() {
		return "RespuestaComparacion [codigoRespuestaDatos=" + codigoRespuestaDatos + ", ocr=" + ocr + ", cic=" + cic
				+ ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
				+ ", anioRegistro=" + anioRegistro + ", anioEmision=" + anioEmision + ", numeroEmisionCredencial="
				+ numeroEmisionCredencial + ", claveElector=" + claveElector + ", curp=" + curp + "]";
	}



	public static class Builder {
		
		private Integer codigoRespuestaDatos;
		private boolean ocr;
		private boolean cic;
		private boolean nombre;
		private boolean apellidoPaterno;
		private boolean apellidoMaterno;
		private boolean anioRegistro;
		private boolean anioEmision;
		private boolean numeroEmisionCredencial;
		private boolean claveElector;
		private boolean curp;
		
		public Builder codigoRespuestaDatos(Integer codigoRespuestaDatos) {
			this.codigoRespuestaDatos = codigoRespuestaDatos;
			return this;
		}
		
		public Builder ocr(boolean ocr) {
			this.ocr = ocr;
			return this;
		}
		
		public Builder cic(boolean cic) {
			this.cic = cic;
			return this;
		}
		
		public Builder nombre(boolean nombre) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder apellidoPaterno(boolean apellidoPaterno) {
			this.apellidoPaterno = apellidoPaterno;
			return this;
		}
		
		public Builder apellidoMaterno(boolean apellidoMaterno) {
			this.apellidoMaterno = apellidoMaterno;
			return this;
		}
		
		public Builder anioRegistro(boolean anioRegistro) {
			this.anioRegistro = anioRegistro;
			return this;
		}
		
		public Builder anioEmision(boolean anioEmision) {
			this.anioEmision = anioEmision;
			return this;
		}
		
		public Builder numeroEmisionCredencial(boolean numeroEmisionCredencial) {
			this.numeroEmisionCredencial = numeroEmisionCredencial;
			return this;
		}
		
		public Builder claveElector(boolean claveElector) {
			this.claveElector = claveElector;
			return this;
		}
		
		public Builder curp(boolean curp) {
			this.curp = curp;
			return this;
		}
		
		public RespuestaComparacion build() {
			return new RespuestaComparacion(this);
		}
		
	}

}
