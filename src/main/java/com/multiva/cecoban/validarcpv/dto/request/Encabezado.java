package com.multiva.cecoban.validarcpv.dto.request;

public class Encabezado {
	
	private String solicitudId;
	private String institucionId;
	private String folioCliente;
	private String tipoProceso;
	
	public String getSolicitudId() {
		return solicitudId;
	}
	public void setSolicitudId(String solicitudId) {
		this.solicitudId = solicitudId;
	}
	public String getInstitucionId() {
		return institucionId;
	}
	public void setInstitucionId(String institucionId) {
		this.institucionId = institucionId;
	}
	public String getFolioCliente() {
		return folioCliente;
	}
	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
	}
	public String getTipoProceso() {
		return tipoProceso;
	}
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

}
