package com.multiva.cecoban.validarcpv.dto.response;

public class Response {
	
	private MinutiaeResponse minutiaeResponse;
	private Integer codigoRespuesta;
	private String fechaHoraPeticion;
	private Integer tiempoProcesamiento;
	private String indiceSolicitud;
	private String peticionId;
	private String folioCliente;
	private String codigoRespuestaCCB;
	private String descripcionRespuestaCCB;
	
	private DataResponse dataResponse;
	
	private Response(Builder builder) {
		this.minutiaeResponse = builder.minutiaeResponse;
		this.codigoRespuesta = builder.codigoRespuesta;
		this.fechaHoraPeticion = builder.fechaHoraPeticion;
		this.tiempoProcesamiento = builder.tiempoProcesamiento;
		this.indiceSolicitud = builder.indiceSolicitud;
		this.peticionId = builder.peticionId;
		this.folioCliente = builder.folioCliente;
		this.codigoRespuestaCCB = builder.codigoRespuestaCCB;
		this.descripcionRespuestaCCB = builder.descripcionRespuestaCCB;
		this.dataResponse = builder.dataResponse;
	}
	
	@Override
	public String toString() {
		return "Response [minutiaeResponse=" + minutiaeResponse + ", codigoRespuesta=" + codigoRespuesta
				+ ", fechaHoraPeticion=" + fechaHoraPeticion + ", tiempoProcesamiento=" + tiempoProcesamiento
				+ ", indiceSolicitud=" + indiceSolicitud + ", peticionId=" + peticionId + ", folioCliente="
				+ folioCliente + ", codigoRespuestaCCB=" + codigoRespuestaCCB + ", descripcionRespuestaCCB="
				+ descripcionRespuestaCCB + ", dataResponse=" + dataResponse + "]";
	}

	public MinutiaeResponse getMinutiaeResponse() {
		return minutiaeResponse;
	}

	public Integer getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public String getFechaHoraPeticion() {
		return fechaHoraPeticion;
	}

	public Integer getTiempoProcesamiento() {
		return tiempoProcesamiento;
	}

	public String getIndiceSolicitud() {
		return indiceSolicitud;
	}

	public String getPeticionId() {
		return peticionId;
	}

	public String getFolioCliente() {
		return folioCliente;
	}

	public String getCodigoRespuestaCCB() {
		return codigoRespuestaCCB;
	}

	public String getDescripcionRespuestaCCB() {
		return descripcionRespuestaCCB;
	}

	public DataResponse getDataResponse() {
		return dataResponse;
	}

	public static class Builder {
		
		private MinutiaeResponse minutiaeResponse;
		private Integer codigoRespuesta;
		private String fechaHoraPeticion;
		private Integer tiempoProcesamiento;
		private String indiceSolicitud;
		private String peticionId;
		private String folioCliente;
		private String codigoRespuestaCCB;
		private String descripcionRespuestaCCB;
		
		private DataResponse dataResponse;
		
		public Builder minutiaeResponse(MinutiaeResponse minutiaeResponse) {
			this.minutiaeResponse = minutiaeResponse;
			return this;
		}
		
		public Builder codigoRespuesta(Integer codigoRespuesta) {
			this.codigoRespuesta = codigoRespuesta;
			return this;
		}
		
		public Builder fechaHoraPeticion(String fechaHoraPeticion) {
			this.fechaHoraPeticion = fechaHoraPeticion;
			return this;
		}
		
		public Builder tiempoProcesamiento(Integer tiempoProcesamiento) {
			this.tiempoProcesamiento = tiempoProcesamiento;
			return this;
		}
		
		public Builder indiceSolicitud(String indiceSolicitud) {
			this.indiceSolicitud = indiceSolicitud;
			return this;
		}
		
		public Builder peticionId(String peticionId) {
			this.peticionId = peticionId;
			return this;
		}
		
		public Builder folioCliente(String folioCliente) {
			this.folioCliente = folioCliente;
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
		
		public Builder dataResponse(DataResponse dataResponse) {
			this.dataResponse = dataResponse;
			return this;
		}
		
		public Response build() {
			return new Response(this);
		}
		
	}
	
}
