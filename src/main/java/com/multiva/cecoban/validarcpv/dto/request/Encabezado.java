package com.multiva.cecoban.validarcpv.dto.request;

import org.springframework.beans.factory.annotation.Value;

public class Encabezado {
	
	private String solicitudId;
	private String institucionId;
	private String folioCliente;
	private String tipoProceso;
	
	private Encabezado(Builder builder) {
		this.solicitudId = builder.solicitudId;
		this.institucionId = builder.institucionId;
		this.folioCliente = builder.folioCliente;
		this.tipoProceso = builder.tipoProceso;
	}
	
	public String getSolicitudId() {
		return solicitudId;
	}

	public String getInstitucionId() {
		return institucionId;
	}

	public String getFolioCliente() {
		return folioCliente;
	}

	public String getTipoProceso() {
		return tipoProceso;
	}

	@Override
	public String toString() {
		return "Encabezado [solicitudId=" + solicitudId + ", institucionId=" + institucionId + ", folioCliente="
				+ folioCliente + ", tipoProceso=" + tipoProceso + "]";
	}


	public static class Builder{
		
		private String solicitudId;
		@Value("${cecoban.validarcpv.institucionid}")
		private String institucionId;
		private String folioCliente;
		@Value("${cecoban.validarcpv.tipoproceso}")
		private String tipoProceso;
		
		public Builder solicitudId(String solicitudId) {
			this.solicitudId = solicitudId;
			return this;
		}
		
		public Builder institucionId(String institucionId) {
			this.institucionId = institucionId;
			return this;
		}
		
		public Builder folioCliente(String folioCliente) {
			this.folioCliente = folioCliente;
			return this;
		}
		
		public Builder tipoProceso(String tipoProceso) {
			this.tipoProceso = tipoProceso;
			return this;
		}
		
		public Encabezado build() {
			return new Encabezado(this);
		}
		
	}

}
