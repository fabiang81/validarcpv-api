package com.multiva.cecoban.validarcpv.dto.response;

public class ComparacionCurp {
	
	private boolean curpCoincide;
	private boolean nombreCoincide;
	private boolean apellidoPaternoCoincide;
	private boolean apellidoMaternoCoincide;
	private String codigoRespuestaCCB;
	private String descripcionRespuestaCCB;
	private String codigoRespuestaRENAPO;
	private String descripcionRespuestaRENAPO;
	
	private ComparacionCurp(Builder builder) {
		this.curpCoincide = builder.curpCoincide;
		this.nombreCoincide = builder.nombreCoincide;
		this.apellidoPaternoCoincide = builder.apellidoPaternoCoincide;
		this.apellidoMaternoCoincide = builder.apellidoMaternoCoincide;
		this.codigoRespuestaCCB = builder.codigoRespuestaCCB;
		this.descripcionRespuestaCCB = builder.descripcionRespuestaCCB;
		this.codigoRespuestaRENAPO = builder.codigoRespuestaRENAPO;
		this.descripcionRespuestaRENAPO = builder.descripcionRespuestaRENAPO;
	}
	
	public boolean isCurpCoincide() {
		return curpCoincide;
	}

	public boolean isNombreCoincide() {
		return nombreCoincide;
	}

	public boolean isApellidoPaternoCoincide() {
		return apellidoPaternoCoincide;
	}

	public boolean isApellidoMaternoCoincide() {
		return apellidoMaternoCoincide;
	}

	public String getCodigoRespuestaCCB() {
		return codigoRespuestaCCB;
	}

	public String getDescripcionRespuestaCCB() {
		return descripcionRespuestaCCB;
	}
	
	public String getCodigoRespuestaRENAPO() {
		return codigoRespuestaRENAPO;
	}

	public String getDescripcionRespuestaRENAPO() {
		return descripcionRespuestaRENAPO;
	}

	@Override
	public String toString() {
		return "ComparacionCurp [curpCoincide=" + curpCoincide + ", nombreCoincide=" + nombreCoincide
				+ ", apellidoPaternoCoincide=" + apellidoPaternoCoincide + ", apellidoMaternoCoincide="
				+ apellidoMaternoCoincide + ", codigoRespuestaCCB=" + codigoRespuestaCCB + ", descripcionRespuestaCCB="
				+ descripcionRespuestaCCB + ", codigoRespuestaRENAPO=" + codigoRespuestaRENAPO
				+ ", descripcionRespuestaRENAPO=" + descripcionRespuestaRENAPO + "]";
	}


	public static class Builder {
		
		private boolean curpCoincide;
		private boolean nombreCoincide;
		private boolean apellidoPaternoCoincide;
		private boolean apellidoMaternoCoincide;
		private String codigoRespuestaCCB;
		private String descripcionRespuestaCCB;
		private String codigoRespuestaRENAPO;
		private String descripcionRespuestaRENAPO;
		
		public Builder curpCoincide(boolean curpCoincide) {
			this.curpCoincide = curpCoincide;
			return this;
		}
		
		public Builder nombreCoincide(boolean nombreCoincide) {
			this.nombreCoincide = nombreCoincide;
			return this;
		}
		
		public Builder apellidoPaternoCoincide(boolean apellidoPaternoCoincide) {
			this.apellidoPaternoCoincide = apellidoPaternoCoincide;
			return this;
		}
		
		public Builder apellidoMaternoCoincide(boolean apellidoMaternoCoincide) {
			this.apellidoMaternoCoincide = apellidoMaternoCoincide;
			return this;
		}
		
		public Builder codigoRespuestaCCB(String codigoRespuestaCCB) {
			this.codigoRespuestaCCB = codigoRespuestaCCB;
			return this;
		}
		
		public Builder descripcionRespuestaCCB(String descripcionRespuestaCCB) {
			this.descripcionRespuestaCCB = descripcionRespuestaCCB;
			return this;
		}
		
		public Builder codigoRespuestaRENAPO(String codigoRespuestaRENAPO) {
			this.codigoRespuestaRENAPO = codigoRespuestaRENAPO;
			return this;
		}
		
		public Builder descripcionRespuestaRENAPO(String descripcionRespuestaRENAPO) {
			this.descripcionRespuestaRENAPO = descripcionRespuestaRENAPO;
			return this;
		}
		
		public ComparacionCurp build() {
			return new ComparacionCurp(this);
		}
		
	}

}
