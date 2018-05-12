package com.multiva.cecoban.validarcpv.dto.request;

public class Datos {
	
	private long ocr;
	private long cic;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String anioRegistro;
	private String anioEmision;
	private String numeroEmisionCredencial;
	private String claveElector;
	private String curp;
	
	private Datos(Builder builder) {
		this.nombre = builder.nombre;
		this.apellidoPaterno = builder.apellidoPaterno;
		this.apellidoMaterno = builder.apellidoMaterno;
		this.ocr = builder.ocr;
		this.cic = builder.cic;
		this.anioRegistro = builder.anioRegistro;
		this.anioEmision = builder.anioEmision;
		this.numeroEmisionCredencial = builder.numeroEmisionCredencial;
		this.claveElector = builder.claveElector;
		this.curp = builder.curp;
		
	}
	
	public long getOcr() {
		return ocr;
	}

	public long getCic() {
		return cic;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public String getAnioRegistro() {
		return anioRegistro;
	}

	public String getAnioEmision() {
		return anioEmision;
	}

	public String getNumeroEmisionCredencial() {
		return numeroEmisionCredencial;
	}

	public String getClaveElector() {
		return claveElector;
	}

	public String getCurp() {
		return curp;
	}

	@Override
	public String toString() {
		return "Datos [ocr=" + ocr + ", cic=" + cic + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", anioRegistro=" + anioRegistro + ", anioEmision="
				+ anioEmision + ", numeroEmisionCredencial=" + numeroEmisionCredencial + ", claveElector="
				+ claveElector + ", curp=" + curp + "]";
	}



	public static class Builder {
		
		private String nombre;
		private String apellidoPaterno;
		private String apellidoMaterno;
		private long ocr;
		private long cic;
		private String anioRegistro;
		private String anioEmision;
		private String numeroEmisionCredencial;
		private String claveElector;
		private String curp;
		
		public Builder nombre(String nombre) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder apellidoPaterno(String apellidoPaterno) {
			this.apellidoPaterno = apellidoPaterno;
			return this;
		}
		
		public Builder apellidoMaterno(String apellidoMaterno) {
			this.apellidoMaterno = apellidoMaterno;
			return this;
		}
		
		public Builder ocr(long ocr) {
			this.ocr = ocr;
			return this;
		}
		
		public Builder cic(long cic) {
			this.cic = cic;
			return this;
		}
		
		public Builder anioRegistro(String anioRegistro) {
			this.anioRegistro = anioRegistro;
			return this;
		}
		
		public Builder anioEmision(String anioEmision) {
			this.anioEmision = anioEmision;
			return this;
		}
		
		public Builder numeroEmisionCredencial(String numeroEmisionCredencial) {
			this.numeroEmisionCredencial = numeroEmisionCredencial;
			return this;
		}
		
		public Builder claveElector(String claveElector) {
			this.claveElector = claveElector;
			return this;
		}
		
		public Builder curp(String curp) {
			this.curp = curp;
			return this;
		}
		
		public Datos build() {
			return new Datos(this);
		}
		
	}

}
