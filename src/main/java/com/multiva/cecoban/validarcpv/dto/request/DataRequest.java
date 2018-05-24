package com.multiva.cecoban.validarcpv.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataRequest {
	
	@JsonProperty(required = true)
	private String ocr;
	@JsonProperty(required = true)
	private String cic;
	@JsonProperty(required = true)
	private String nombre;
	@JsonProperty(required = true)
	private String apellidoPaterno;
	@JsonProperty(required = false)
	private String apellidoMaterno;
	@JsonProperty(required = false)
	private String anioRegistro;
	@JsonProperty(required = false)
	private String anioEmision;
	@JsonProperty(required = true)
	private String numeroEmision;
	@JsonProperty(required = true)
	private String claveElector;
	@JsonProperty(required = false)
	private String curp;
	@JsonProperty(required = true)
	private String codigoPostal;
	@JsonProperty(required = true)
	private String ciudad;
	@JsonProperty(required = true)
	private int estado;
	@JsonProperty(required = false)
	private String imagenIndiceDerecho;
	@JsonProperty(required = false)
	private String imagenIndiceIzquierdo;
	@JsonProperty(required = true)
	private boolean consentimiento;
	
	public String getOcr() {
		return ocr;
	}
	public void setOcr(String ocr) {
		this.ocr = ocr;
	}
	public String getCic() {
		return cic;
	}
	public void setCic(String cic) {
		this.cic = cic;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getAnioRegistro() {
		return anioRegistro;
	}
	public void setAnioRegistro(String anioRegistro) {
		this.anioRegistro = anioRegistro;
	}
	public String getAnioEmision() {
		return anioEmision;
	}
	public void setAnioEmision(String anioEmision) {
		this.anioEmision = anioEmision;
	}
	public String getNumeroEmision() {
		return numeroEmision;
	}
	public void setNumeroEmision(String numeroEmision) {
		this.numeroEmision = numeroEmision;
	}
	public String getClaveElector() {
		return claveElector;
	}
	public void setClaveElector(String claveElector) {
		this.claveElector = claveElector;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getImagenIndiceDerecho() {
		return imagenIndiceDerecho;
	}
	public void setImagenIndiceDerecho(String imagenIndiceDerecho) {
		this.imagenIndiceDerecho = imagenIndiceDerecho;
	}
	public String getImagenIndiceIzquierdo() {
		return imagenIndiceIzquierdo;
	}
	public void setImagenIndiceIzquierdo(String imagenIndiceIzquierdo) {
		this.imagenIndiceIzquierdo = imagenIndiceIzquierdo;
	}
	public boolean isConsentimiento() {
		return consentimiento;
	}
	public void setConsentimiento(boolean consentimiento) {
		this.consentimiento = consentimiento;
	}

}
